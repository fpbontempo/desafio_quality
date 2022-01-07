package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/***
 * Entidade Comodo
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comodo  {
    /***
     * Nome do cômodo
     */
    private String nome;
    /***
     * largura
     */
    private Double largura;
    /***
     * comprimento
     */
    private Double comprimento;

    public double calculaAreaComodo() {
        return largura * comprimento;
    }
}
