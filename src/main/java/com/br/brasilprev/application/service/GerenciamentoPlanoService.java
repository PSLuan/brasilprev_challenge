package com.br.brasilprev.application.service;

import com.br.brasilprev.infrastructure.request.AporteExtraRequest;
import com.br.brasilprev.infrastructure.request.GerenciamentoPlanoRequest;
import com.br.brasilprev.infrastructure.request.ResgateRequest;
import com.br.brasilprev.infrastructure.response.GerenciamentoPlanoResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GerenciamentoPlanoService {

    ResponseEntity<Long> save(GerenciamentoPlanoRequest gerenciamentoPlanoRequest);

    ResponseEntity<List<GerenciamentoPlanoResponse>> findAll();

    ResponseEntity<GerenciamentoPlanoResponse> findById(Long id);

    ResponseEntity<Long> aporteExtra(AporteExtraRequest aporteExtraRequest);

    ResponseEntity<Long> resgate(ResgateRequest resgateRequest);
}
