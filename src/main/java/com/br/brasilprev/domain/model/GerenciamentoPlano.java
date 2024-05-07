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
@Table(name = "gerenciamento_plano")
public class GerenciamentoPlano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Produto produto;

    private Double aporte;

    @Column(name = "data_contratacao")
    private LocalDateTime dataDaContratacao;

    @Column(name = "idade_aposentadoria")
    private Integer idadeDeAposentadoria;

    @Column(name = "data_resgate")
    private LocalDateTime dataDoResgate;

    @Column(name = "ativo")
    private Boolean ativo;

}
