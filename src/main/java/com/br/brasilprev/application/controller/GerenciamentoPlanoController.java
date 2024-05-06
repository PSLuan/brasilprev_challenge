package com.br.brasilprev.application.controller;

import com.br.brasilprev.application.service.GerenciamentoPlanoService;
import com.br.brasilprev.infrastructure.request.AporteExtraRequest;
import com.br.brasilprev.infrastructure.request.GerenciamentoPlanoRequest;
import com.br.brasilprev.infrastructure.request.ResgateRequest;
import com.br.brasilprev.infrastructure.response.GerenciamentoPlanoResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/gerenciamento-plano")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class GerenciamentoPlanoController {

    private final GerenciamentoPlanoService gerenciamentoPlanoService;

    @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> save(@RequestBody GerenciamentoPlanoRequest gerenciamentoPlanoRequest) {
        return gerenciamentoPlanoService.save(gerenciamentoPlanoRequest);
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GerenciamentoPlanoResponse>> findAll() {
        return gerenciamentoPlanoService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GerenciamentoPlanoResponse> findById(@PathVariable Long id) {return gerenciamentoPlanoService.findById(id);}

    @PatchMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> aporteExtra(@RequestBody AporteExtraRequest aporteExtraRequest) {
        return gerenciamentoPlanoService.aporteExtra(aporteExtraRequest);
    }

    @PatchMapping(value = "/resgate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Long> resgate(@RequestBody ResgateRequest request) {
        return gerenciamentoPlanoService.resgate(request);
    }

}
