package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Comodo;
import lombok.AllArgsConstructor;
import lombok.Data;


import javax.validation.constraints.*;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Comodo DTO
 * @author Leonardo *----*
 * @author Fernando Netto
 */
@Data
@AllArgsConstructor
public class ComodoDto {

    /***
     * campo nome do comodo, retorna as validações solicitadas no documento fornecido
     *  1 — Que o campo nao poder estar vazio
     *  2 — Que comece com uma letra Maiúscula
     *  3 — Comprimento máximo de 30 caracteres.
     */
    @NotNull(message = "O campo nome e obrigatório")
    @NotBlank(message = "O campo nao pode ser branco")
    @NotEmpty(message = "O campo nao pode ser vazio")
    @Size(min = 3, max = 30, message="O nome do comodo deve estar entre 3 e 30 caracteres")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]+", message = "O nome do comodo deve começar com letra maiúscula")
    private final String nome;

    /***
     * campo largura do comodo, retorna as validações solicitadas no documento fornecido
     *  1 — Que o campo nao pode estar nulo
     *  2 — Comprimento máximo de 25 metros.
     */
    @NotNull(message = "Largura é obrigatória")
    @Max(value = 25, message = "Largura não pode ser maior que 25 m")
    @Positive(message = "Largura deve ser maior que 0")
    private final Double largura;

    /***
     * campo largura do comodo, retorna as validações solicitadas no documento fornecido
     *  1 — Que o campo nao pode estar nulo
     *  2 — Comprimento máximo de 33 metros.
     */
    @NotNull(message = "Comprimento é obrigatória")
    @Max(value = 33, message = "Comprimento não pode ser maior que 33 m")
    @Positive(message = "Comprimento deve ser maior que 0")
    private final Double comprimento;

    /***
     * conversor DTO para Entidade
     * @param comodo comodo DTO
     * @return comodo
     */
    public static Comodo converte(ComodoDto comodo) {
        return new Comodo(comodo.getNome(),comodo.getLargura(),comodo.getComprimento());
    }

    /***
     * conversor Entidade para DTO
     * @param comodo comodo
     * @return comodo DTO
     */
    public static ComodoDto converte(Comodo comodo) {
        return new ComodoDto(comodo.getNome(),comodo.getLargura(),comodo.getComprimento());
    }

    /***
     * Conversor de lista de Cômodos, de Entidade para DTO
     * @param comodos lista de cômodos
     * @return lista de cômodos DTO
     */
    public static List<ComodoDto> converteLista(List<Comodo> comodos) {
        return comodos.stream().map(ComodoDto::converte).collect(Collectors.toList());
    }

    /***
     * Conversor de lista de Cômodos, de DTO para Entidade
     * @param comodos lista de cômodos DTO
     * @return lista de cômodos
     */
    public static List<Comodo> converteListaDto(List<ComodoDto> comodos) {
        return comodos.stream().map(ComodoDto::converte).collect(Collectors.toList());
    }
}
