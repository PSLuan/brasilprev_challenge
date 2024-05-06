package com.br.brasilprev.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf;

    private String nome;

    private String email;

    @Column(name = "data_nascimento")
    private LocalDateTime dataDeNascimento;

    private String genero;

    @Column(name = "renda_mensal")
    private Double rendaMensal;
}
