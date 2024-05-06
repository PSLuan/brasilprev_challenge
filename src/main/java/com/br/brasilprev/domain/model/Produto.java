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
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String susep;

    @Column(name = "expiracao_venda")
    private LocalDateTime expiracaoDeVenda;

    @Column(name = "valor_minimo_aporte_inicial")
    private Double valorMinimoAporteInicial;

    @Column(name = "valor_minimo_aporte_extra")
    private Double valorMinimoAporteExtra;

    @Column(name = "idade_entrada")
    private Integer idadeEntrada;

    @Column(name = "idade_saida")
    private Integer idadeSaida;

    @Column(name = "carencia_inicial_resgate")
    private Integer carenciaInicialDeResgate;

    @Column(name = "carencia_entre_resgates")
    private Integer carenciaEntreResgates;

}
