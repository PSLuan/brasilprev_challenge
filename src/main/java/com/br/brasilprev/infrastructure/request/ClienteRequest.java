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
public class ClienteRequest {

    @JsonProperty(value = "cpf")
    private String cpf;

    @JsonProperty(value = "nome")
    private String nome;

    @JsonProperty(value = "email")
    private String email;

    @JsonProperty(value = "dataDeNascimento")
    private String dataDeNascimento;

    @JsonProperty(value = "genero")
    private String genero;

    @JsonProperty(value = "rendaMensal")
    private Double rendaMensal;
}
