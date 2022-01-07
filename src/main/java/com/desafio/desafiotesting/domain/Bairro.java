package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/***
 * Entidade Bairro
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bairro {
    /***
     * Nome do bairro
     */
    private String nome;
    /***
     * valor do metro quadrado
     */
    private BigDecimal valorMetroQuadrado;
}
