package com.br.brasilprev.application.service;

import com.br.brasilprev.infrastructure.request.ProdutoRequest;
import com.br.brasilprev.infrastructure.response.ProdutoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoService {

    ResponseEntity<Long> save(ProdutoRequest produtoRequest);

    ResponseEntity<List<ProdutoResponse>> findAll();

    ResponseEntity<ProdutoResponse> findById(Long id);
}
