package com.br.brasilprev.infrastructure.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GerenciamentoPlanoResponse {

    @JsonProperty(value = "id")
    private Long id;

    @JsonProperty(value = "idCliente")
    private Long idCliente;

    @JsonProperty(value = "idProduto")
    private Long idProduto;
}
