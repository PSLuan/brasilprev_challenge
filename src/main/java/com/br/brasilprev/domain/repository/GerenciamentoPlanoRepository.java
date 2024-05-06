package com.br.brasilprev.domain.repository;

import com.br.brasilprev.domain.model.GerenciamentoPlano;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GerenciamentoPlanoRepository extends JpaRepository<GerenciamentoPlano, Long> {

    Optional<GerenciamentoPlano> findGerenciamentoPlanoByIdAndClienteId(Long id, Long idCliente);
}
