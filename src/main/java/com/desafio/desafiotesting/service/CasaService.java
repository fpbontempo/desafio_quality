package com.desafio.desafiotesting.service;

import com.desafio.desafiotesting.domain.Casa;
import com.desafio.desafiotesting.domain.Comodo;
import com.desafio.desafiotesting.domain.Bairro;
import com.desafio.desafiotesting.exception.RepositoryException;
import com.desafio.desafiotesting.repository.CasaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.List;

/***
 * Casa service
 */
@Service
@AllArgsConstructor
public class CasaService {

    /***
     * service do bairro
     */
    BairroService bairroService;
    /***
     * repositório da casa
     */
    CasaRepository casaRepository;

    /***
     * Calcula area total do Imóvel
     * @param casa casa
     * @return area
     */
    private double calcularAreaTotal(Casa casa) {
        double areaTotal = 0;
        for (Comodo com : casa.getComodos()) areaTotal += com.calculaAreaComodo();
        return areaTotal;
    }

    /***
     * busca todas casas
     * @return lista de casas
     */
    public List<Casa> findAll() {
        return casaRepository.findAll();
    }

    /***
     * busca casa pelo nome, se não existir, lança exceção
     * @param nome nome
     * @return casa
     */
    public Casa findByNome(String nome) {
        Casa casa = casaRepository.findByNome(nome);
        if (casa == null) throw new RepositoryException("Casa inexistente.");
        return casa;
    }

    /***
     * calcula área da casa
     * @param nome nome da casa
     * @return área da casa
     */
    public String getAreaCasa(String nome) {
        Casa casa = findByNome(nome);
        double area = calcularAreaTotal(casa);
        return "A área total da casa é de: " + area + " metros.";
    }

    /***
     * calcula valor da casa
     * @param nome nome
     * @return valor da casa
     */
    public String getValorCasa(String nome) {
        Casa casa = findByNome(nome);
        double area = calcularAreaTotal(casa);
        Bairro bairro = bairroService.findByNome(casa.getBairro());
        BigDecimal valorM2 = bairro.getValorMetroQuadrado();
        BigDecimal valorCasa = valorM2.multiply(new BigDecimal(area));
        return "O valor da casa é: " + NumberFormat.getCurrencyInstance().format(valorCasa);
    }

    /***
     * calcula maior cômodo
     * @param nome nome da casa
     * @return maior cômodo
     */
    public String getMaiorComodo(String nome) {
        Casa casa = findByNome(nome);
        double maiorComodo = 0;
        double areaComodo;
        String nomeComodo = "";
        for (Comodo c : casa.getComodos()) {
            areaComodo = c.calculaAreaComodo();
            if (areaComodo > maiorComodo) {
                maiorComodo = areaComodo;
                nomeComodo = c.getNome();
            }
        }
        return "O maior comodo da casa " + nome + ": " +
                nomeComodo + " com área de " + maiorComodo + " metros quadrados.";
    }

    /***
     * busca área de todos os cômodos
     * @param nomeDaCasa nome da casa
     * @return área de todos os comodos
     */
    public String getAreaComodos(String nomeDaCasa) {
        StringBuilder areaComodos = new StringBuilder();
        Casa casa = casaRepository.findByNome(nomeDaCasa);
        for (Comodo com : casa.getComodos()) {
            areaComodos.append("Comodo: ").append(com.getNome()).append(" com ")
                    .append(com.calculaAreaComodo()).append(" metros quadrados<br>");
        }
        return "A area de cada comodo da casa " + nomeDaCasa + " é: <br>" + areaComodos;
    }

    /***
     * salva casa
     * @param casa casa
     */
    public void salvarCasa(Casa casa) {
        bairroService.findByNome(casa.getBairro()); // lança exceção se nao existe o bairro
        this.verificarCasaExistente(casa.getNome()); // lança exceção se casa ja existe
        casaRepository.salvar(casa);
    }

    /***
     * verifica se casa não existe, se existe, lança exceção
     * @param nome nome
     */
    private void verificarCasaExistente(String nome){
        if ( casaRepository.findByNome(nome) != null )
            throw new RepositoryException("Já existe uma casa com esse nome");
    }
}
