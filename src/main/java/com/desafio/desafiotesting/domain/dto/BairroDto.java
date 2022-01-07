package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Bairro;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Bairro DTO
 */
@Data
@AllArgsConstructor
public class BairroDto {
    /***
     * Nome do bairro deve ter de 3 a 45 caracteres, iniciado por letra maiúscula
     */
    @NotNull(message = "Nome do bairro é obrigatório")
    @NotEmpty(message = "Nome do bairro é obrigatório")
    @Size(min = 3, max = 45, message = "tamanho: mínimo 3, máximo 45")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]+", message = "O nome do bairro deve começar com letra maiúscula")
    private final String nome;

    /***
     * Valor do metro quadrado deve ter 13 dígitos, eser positivo
     */
    @Digits(integer = 11, fraction = 2, message = "O valor não pode ultrapassar 13 dígitos (11 inteiro e 2 decimais)")
    @NotNull(message = "Valor do m2 é obrigatório")
    @Positive(message = "O valor do m2 deve ser positivo")
    private final BigDecimal valorMetroQuadrado;

    /***
     * conversor DTO para Entidade
     * @param bairro bairro DTO
     * @return bairro
     */
    public static Bairro converte(BairroDto bairro) {
        return new Bairro(bairro.getNome(), bairro.getValorMetroQuadrado());
    }

    /***
     * conversor Entidade para DTO
     * @param bairro bairro
     * @return bairro DTO
     */
    public static BairroDto converte(Bairro bairro) {
        return new BairroDto(bairro.getNome(), bairro.getValorMetroQuadrado());
    }

    /***
     * Conversor de lista de Bairros, de Entidade para DTO
     * @param bairros lista de bairros
     * @return lista de bairros DTO
     */
    public static List<BairroDto> converteLista(List<Bairro> bairros) {
        return bairros.stream().map(BairroDto::converte).collect(Collectors.toList());
    }

    /***
     * Conversor de lista de Bairros, de DTO para Entidade
     * @param bairros lista de bairros DTO
     * @return lista de bairros
     */
    public static List<Bairro> converteListaDto(List<BairroDto> bairros) {
        return bairros.stream().map(BairroDto::converte).collect(Collectors.toList());
    }
}
