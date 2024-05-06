package com.br.brasilprev.application.service.impl;

import com.br.brasilprev.application.service.ClienteService;
import com.br.brasilprev.domain.model.Cliente;
import com.br.brasilprev.domain.repository.ClienteRepository;
import com.br.brasilprev.infrastructure.request.ClienteRequest;
import com.br.brasilprev.infrastructure.response.ClienteResponse;
import com.br.brasilprev.utils.ClienteUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public ResponseEntity<Long> save(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRepository.save(Cliente.builder()
                .id(null)
                .cpf(clienteRequest.getCpf())
                .nome(clienteRequest.getNome())
                .email(clienteRequest.getEmail())
                .dataDeNascimento(OffsetDateTime.parse(clienteRequest.getDataDeNascimento()).toLocalDateTime())
                .genero(clienteRequest.getGenero())
                .rendaMensal(clienteRequest.getRendaMensal())
                .build());
        return ResponseEntity.ok(cliente.getId());
    }

    @Override
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return ResponseEntity.ok(ClienteUtils.getClientes(clienteRepository.findAll()));
    }

    @Override
    public ResponseEntity<ClienteResponse> findById(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.map(value -> ResponseEntity.ok(ClienteResponse.builder()
                .id(value.getId())
                .nome(value.getNome())
                .build())).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
