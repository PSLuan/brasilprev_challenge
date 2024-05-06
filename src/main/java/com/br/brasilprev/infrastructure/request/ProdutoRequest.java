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
public class ProdutoRequest {

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "susep")
    private String susep;

    @JsonProperty(value = "expiracaoDeVenda")
    private String expiracaoDeVenda;

    @JsonProperty(value = "valorMinimoAporteInicial")
    private Double valorMinimoAporteInicial;

    @JsonProperty(value = "valorMinimoAporteExtra")
    private Double valorMinimoAporteExtra;

    @JsonProperty(value = "idadeDeEntrada")
    private Integer idadeDeEntrada;

    @JsonProperty(value = "idadeDeSaida")
    private Integer idadeDeSaida;

    @JsonProperty(value = "carenciaInicialDeResgate")
    private Integer carenciaInicialDeResgate;

    @JsonProperty(value = "carenciaEntreResgates")
    private Integer carenciaEntreResgates;

}
