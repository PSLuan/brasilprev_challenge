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
public class AporteExtraRequest {

    @JsonProperty(value = "idCliente")
    private Long idCliente;

    @JsonProperty(value = "idPlano")
    private Long idPlano;

    @JsonProperty(value = "valorAporte")
    private Double valorAporte;
}
