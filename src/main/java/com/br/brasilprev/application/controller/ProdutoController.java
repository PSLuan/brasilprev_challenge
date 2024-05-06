package com.br.brasilprev.application.controller;

import com.br.brasilprev.application.service.ProdutoService;
import com.br.brasilprev.infrastructure.request.ProdutoRequest;
import com.br.brasilprev.infrastructure.response.ProdutoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/produto")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> save(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.save(produtoRequest);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProdutoResponse>> findAll() {
        return produtoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {return produtoService.findById(id);}
}
