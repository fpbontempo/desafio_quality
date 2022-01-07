package com.desafio.desafiotesting.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Entidade Casa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Casa {
    /***
     * nome da casa
     */
    private String nome;
    /***
     * nome do bairro
     */
    private String bairro;
    /***
     * lista de cômodos
     */
    private List<Comodo> comodos;
}
