package com.br.brasilprev.infrastructure.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GerenciamentoPlanoRequest {

    @JsonProperty(value = "idCliente")
    private Long idCliente;

    @JsonProperty(value = "idProduto")
    private Long idProduto;

    @JsonProperty(value = "aporte")
    private Double aporte;

    @JsonProperty(value = "dataDaContratacao")
    private String dataDaContratacao;

    @JsonProperty(value = "idadeDeAposentadoria")
    private Integer idadeDeAposentadoria;
}
