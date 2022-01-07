package com.desafio.desafiotesting.domain.dto;

import com.desafio.desafiotesting.domain.Casa;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.stream.Collectors;

/***
 * Casa DTO
 */
@Data
@AllArgsConstructor
public class CasaDto {
    /***
     * Nome da casa deve ter de 3 a 30 caracteres, iniciado por letra maiúscula
     */
    @NotNull(message = "Campo obrigatório")
    @NotEmpty(message = "Campo não pode estar em branco")
    @Size(min = 3, max = 30, message = "tamanho min 3 e max 30")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]+", message = "Deve conter apenas letras, e primeira letra deve ser maiúscula")
    private final String nome;

    /***
     * nome do bairro deve ter de 3 a 45 caracteres, iniciado por maiúscula
     */
    @NotNull(message = "nome é obrigatório")
    @NotEmpty(message = "nome é obrigatório")
    @Size(min = 3, max = 45, message = "tamanho mínimo 3, máximo 45")
    @Pattern(regexp = "^[A-Z][a-zA-Z0-9 ]+", message = "O nome do bairro deve começar com letra maiúscula")
    private final String bairro;

    /***
     * lista de cômodos
     */
    @Valid
    @NotNull(message = "aluno deve ter disciplinas")
    private final List<ComodoDto> comodos;

    /***
     * conversor DTO para Entidade
     * @param casa casa DTO
     * @return casa
     */
    public static Casa converte(CasaDto casa) {
        return new Casa(casa.getNome(), casa.getBairro(), ComodoDto.converteListaDto(casa.getComodos()));
    }

    /***
     * conversor Entidade para DTO
     * @param casa casa
     * @return casa DTO
     */
    public static CasaDto converte(Casa casa) {
        return new CasaDto(casa.getNome(), casa.getBairro(), ComodoDto.converteLista(casa.getComodos()));
    }

    /***
     * Conversor de lista de Casas, de Entidade para DTO
     * @param casas lista de casas
     * @return lista de casas DTO
     */
    public static List<CasaDto> converteLista(List<Casa> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }

    /***
     * Conversor de lista de Casas, de DTO para Entidade
     * @param casas lista de casas DTO
     * @return lista de casas
     */
    public static List<Casa> converteListaDto(List<CasaDto> casas) {
        return casas.stream().map(CasaDto::converte).collect(Collectors.toList());
    }
}
