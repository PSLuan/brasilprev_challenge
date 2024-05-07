package com.br.brasilprev.application.service.impl;

import com.br.brasilprev.application.service.GerenciamentoPlanoService;
import com.br.brasilprev.domain.model.Cliente;
import com.br.brasilprev.domain.model.GerenciamentoPlano;
import com.br.brasilprev.domain.model.Produto;
import com.br.brasilprev.domain.repository.ClienteRepository;
import com.br.brasilprev.domain.repository.GerenciamentoPlanoRepository;
import com.br.brasilprev.domain.repository.ProdutoRepository;
import com.br.brasilprev.infrastructure.request.AporteExtraRequest;
import com.br.brasilprev.infrastructure.request.GerenciamentoPlanoRequest;
import com.br.brasilprev.infrastructure.request.ResgateRequest;
import com.br.brasilprev.infrastructure.response.GerenciamentoPlanoResponse;
import com.br.brasilprev.utils.GerenciamentoPlanoUtils;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GerenciamentoPlanoServiceImpl implements GerenciamentoPlanoService {

    private static final Logger log = LoggerFactory.getLogger(GerenciamentoPlanoServiceImpl.class);
    private final GerenciamentoPlanoRepository gerenciamentoPlanoRepository;
    private final ClienteRepository clienteRepository;
    private final ProdutoRepository produtoRepository;


    @Override
    public ResponseEntity<Long> save(GerenciamentoPlanoRequest gerenciamentoPlanoRequest) {
        Optional<Cliente> cliente = clienteRepository.findById(gerenciamentoPlanoRequest.getIdCliente());
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Optional<Produto> produto = produtoRepository.findById(gerenciamentoPlanoRequest.getIdProduto());
        if (produto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        LocalDateTime idadeAceita = LocalDateTime.now().minusYears(produto.get().getIdadeEntrada());
        if (LocalDateTime.now().isBefore(produto.get().getExpiracaoDeVenda())) {
            if (cliente.get().getDataDeNascimento().isBefore(idadeAceita)) { //maior que idade de entrada
                idadeAceita = LocalDateTime.now().minusYears(produto.get().getIdadeSaida());
                if (cliente.get().getDataDeNascimento().isAfter(idadeAceita)) { //menor que idade de saida
                    if (gerenciamentoPlanoRequest.getAporte() >= produto.get().getValorMinimoAporteInicial()) { //validar o valor inicial de aporte
                        GerenciamentoPlano gerenciamentoPlano = gerenciamentoPlanoRepository.save(GerenciamentoPlano.builder()
                                .id(null)
                                .cliente(cliente.get())
                                .produto(produto.get())
                                .aporte(gerenciamentoPlanoRequest.getAporte())
                                .dataDaContratacao(OffsetDateTime.parse(gerenciamentoPlanoRequest.getDataDaContratacao()).toLocalDateTime())
                                .idadeDeAposentadoria(gerenciamentoPlanoRequest.getIdadeDeAposentadoria())
                                .build());
                        return ResponseEntity.ok(gerenciamentoPlano.getId());
                    }
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<List<GerenciamentoPlanoResponse>> findAll() {
        return ResponseEntity.ok(GerenciamentoPlanoUtils.getGerenciamentoPlanos(gerenciamentoPlanoRepository.findAll()));
    }

    @Override
    public ResponseEntity<GerenciamentoPlanoResponse> findById(Long id) {
        Optional<GerenciamentoPlano> gerenciamentoPlano = gerenciamentoPlanoRepository.findById(id);
        return gerenciamentoPlano.map(value -> ResponseEntity.ok(GerenciamentoPlanoResponse.builder()
                .id(value.getId())
                .idCliente(value.getCliente().getId())
                .idProduto(value.getProduto().getId()).build())).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<Long> aporteExtra(AporteExtraRequest aporteExtraRequest) {
        Optional<GerenciamentoPlano> gerenciamentoPlano = gerenciamentoPlanoRepository.findGerenciamentoPlanoByIdAndClienteId(aporteExtraRequest.getIdPlano(), aporteExtraRequest.getIdCliente());
        if (gerenciamentoPlano.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (aporteExtraRequest.getValorAporte() >= gerenciamentoPlano.get().getProduto().getValorMinimoAporteExtra()) { //validar valor extra de aporte
            gerenciamentoPlano.get().setAporte(gerenciamentoPlano.get().getAporte() + aporteExtraRequest.getValorAporte());
            gerenciamentoPlanoRepository.save(gerenciamentoPlano.get());
            return ResponseEntity.ok(gerenciamentoPlano.get().getId());
        }
        return ResponseEntity.badRequest().build();
    }

    @Override
    public ResponseEntity<Long> resgate(ResgateRequest resgateRequest) {
        Optional<GerenciamentoPlano> gerenciamentoPlano = gerenciamentoPlanoRepository.findById(resgateRequest.getIdPlano());
        if (gerenciamentoPlano.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        if (LocalDateTime.now().isAfter(gerenciamentoPlano.get().getDataDaContratacao().plusDays(gerenciamentoPlano.get().getProduto().getCarenciaInicialDeResgate()))) {
            if (gerenciamentoPlano.get().getAporte() >= resgateRequest.getValorResgate()) {
                if (gerenciamentoPlano.get().getDataDoResgate() != null) {
                    if (gerenciamentoPlano.get().getDataDoResgate().isBefore(gerenciamentoPlano.get().getDataDoResgate().minusDays(gerenciamentoPlano.get().getProduto().getCarenciaEntreResgates()))) {
                        gerenciamentoPlano.get().setAporte(gerenciamentoPlano.get().getAporte() - resgateRequest.getValorResgate());
                        gerenciamentoPlanoRepository.save(gerenciamentoPlano.get());
                        return ResponseEntity.ok(gerenciamentoPlano.get().getId());
                    }
                } else {
                    gerenciamentoPlano.get().setAporte(gerenciamentoPlano.get().getAporte() - resgateRequest.getValorResgate());
                    gerenciamentoPlanoRepository.save(gerenciamentoPlano.get());
                    return ResponseEntity.ok(gerenciamentoPlano.get().getId());
                }
            }
        }
        return ResponseEntity.badRequest().build();
    }

}
