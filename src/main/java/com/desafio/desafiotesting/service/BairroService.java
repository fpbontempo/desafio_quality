package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.BairroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * Service bairro
 */
@Service
@AllArgsConstructor
public class BairroService {

    /***
     * repositório do bairro
     */
    BairroRepository bairroRepository;

    /***
     * busca todos os bairros
     * @return lista de lairros
     */
    public List<Bairro> findAll() {
        return bairroRepository.findAll();
    }

    public Bairro findByNome(String nome) {
        Bairro bairro = bairroRepository.findByNome(nome);
        if (bairro == null) throw new RepositoryException("Bairro inexistente.");
        return bairro;
    }

    /***
     * salva bairro
     * @param bairro bairro
     */
    public void salvar(Bairro bairro) {
        this.verificarBairroExistente(bairro.getNome());
        bairroRepository.salvar(bairro);
    }

    /***
     * verifica se bairro não existe, lança exceção se bairro ja existe
     * @param nome nome
     */
    private void verificarBairroExistente(String nome){
        if ( bairroRepository.findByNome(nome) != null)
            throw new RepositoryException("Ja existe bairro com esse nome.");
    }
}
