package com.br.brasilprev.application.service.impl;

import com.br.brasilprev.application.service.ProdutoService;
import com.br.brasilprev.domain.model.Produto;
import com.br.brasilprev.domain.repository.ProdutoRepository;
import com.br.brasilprev.infrastructure.request.ProdutoRequest;
import com.br.brasilprev.infrastructure.response.ProdutoResponse;
import com.br.brasilprev.utils.ProdutoUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;


    @Override
    public ResponseEntity<Long> save(ProdutoRequest produtoRequest) {
        Produto produto = produtoRepository.save(Produto.builder()
                .id(null)
                .nome(produtoRequest.getNome())
                .susep(produtoRequest.getSusep())
                .expiracaoDeVenda(OffsetDateTime.parse(produtoRequest.getExpiracaoDeVenda()).toLocalDateTime())
                .valorMinimoAporteInicial(produtoRequest.getValorMinimoAporteInicial())
                .valorMinimoAporteExtra(produtoRequest.getValorMinimoAporteExtra())
                .idadeEntrada(produtoRequest.getIdadeDeEntrada())
                .idadeSaida(produtoRequest.getIdadeDeSaida())
                .carenciaInicialDeResgate(produtoRequest.getCarenciaInicialDeResgate())
                .carenciaEntreResgates(produtoRequest.getCarenciaEntreResgates())
                .build());

        return ResponseEntity.ok(produto.getId());
    }

    @Override
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return ResponseEntity.ok(ProdutoUtils.getProdutos(produtoRepository.findAll()));
    }

    @Override
    public ResponseEntity<ProdutoResponse> findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.map(value -> ResponseEntity.ok(ProdutoResponse.builder()
                .id(value.getId())
                .nome(value.getNome())
                .build())).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
