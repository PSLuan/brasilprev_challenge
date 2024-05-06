package com.br.brasilprev.utils;

import com.br.brasilprev.domain.model.GerenciamentoPlano;
import com.br.brasilprev.infrastructure.response.GerenciamentoPlanoResponse;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GerenciamentoPlanoUtils {

    public static List<GerenciamentoPlanoResponse> getGerenciamentoPlanos(List<GerenciamentoPlano> gerenciamentoPlanos) {
        return gerenciamentoPlanos.stream()
                .map(gerenciamentoPlano -> new GerenciamentoPlanoResponse(gerenciamentoPlano.getId(), gerenciamentoPlano.getCliente().getId(), gerenciamentoPlano.getProduto().getId()))
                .collect(Collectors.toList());
    }
}
