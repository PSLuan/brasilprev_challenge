package com.br.brasilprev.application.service;

import com.br.brasilprev.infrastructure.request.ClienteRequest;
import com.br.brasilprev.infrastructure.response.ClienteResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {

    ResponseEntity<Long> save(ClienteRequest clienteRequest);

    ResponseEntity<List<ClienteResponse>> findAll();

    ResponseEntity<ClienteResponse> findById(Long id);

}
