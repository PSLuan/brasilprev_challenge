package com.br.brasilprev.application.controller;

import com.br.brasilprev.application.service.ClienteService;
import com.br.brasilprev.infrastructure.request.AporteExtraRequest;
import com.br.brasilprev.infrastructure.request.ClienteRequest;
import com.br.brasilprev.infrastructure.response.ClienteResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> save(@RequestBody ClienteRequest clienteRequest) {
        return clienteService.save(clienteRequest);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClienteResponse>> findAll() {
        return clienteService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClienteResponse> findById(@PathVariable Long id) {
        return clienteService.findById(id);
    }

}
