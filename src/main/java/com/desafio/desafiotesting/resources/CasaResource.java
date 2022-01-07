package com.desafio.desafiotesting.resources;

import com.desafio.desafiotesting.domain.dto.CasaDto;
import com.desafio.desafiotesting.service.CasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/***
 * Controller de Casa
 */
@RestController
@RequestMapping(value = "/casas")
public class CasaResource {

    /***
     * AutoWired de casa service
     */
    @Autowired
    private CasaService casaService;

    /***
     * Cadastra casa
     * @param casa casa
     * @param uriBuilder uri builder
     * @return casa cadastrada
     */
    @PostMapping("/cadastrarCasa")
    public ResponseEntity<CasaDto> cadastrarCasa(@RequestBody @Valid  CasaDto casa, UriComponentsBuilder uriBuilder){
        casaService.salvarCasa(CasaDto.converte(casa));
        URI uri = uriBuilder
                .path("/casas/{nome}")
                .buildAndExpand(casa.getNome())
                .toUri();
        return ResponseEntity.created(uri).body(casa);
    }

    /***
     * Busca todas casas
     * @return lista de casas
     */
    @GetMapping
    public ResponseEntity<List<CasaDto>> findAll() {
        List<CasaDto> list = CasaDto.converteLista(casaService.findAll());
        return ResponseEntity.ok(list);
    }

    /***
     * busca casa pelo nome
     * @param nome nome da casa
     * @return casa
     */
    @GetMapping(value = "/{nome}")
    public ResponseEntity<CasaDto> findByNome(@PathVariable String nome) {
        CasaDto casa = CasaDto.converte(casaService.findByNome(nome));
        return ResponseEntity.ok(casa);
    }

    /***
     * Area totol de uma casa
     * @param nome nome da casa
     * @return area total
     */
    @GetMapping(value = "/area/{nome}")
    public ResponseEntity<String> areaTotal(@PathVariable String nome) {
        String casa = casaService.getAreaCasa(nome);
        return ResponseEntity.ok(casa);
    }

    /***
     * valor da casa
     * @param nome nome da casa
     * @return valor da casa
     */
    @GetMapping(value = "/valorCasa/{nome}")
    public ResponseEntity<String> valorCasa(@PathVariable String nome) {
        String valorCasa = casaService.getValorCasa(nome);
        return ResponseEntity.ok(valorCasa);
    }

    /***
     * maior comodo da casa
     * @param nome nome da casa
     * @return maior comodo
     */
    @GetMapping(value = "/maiorComodo/{nome}")
    public ResponseEntity<String> maiorComodo(@PathVariable String nome){
        String maiorComodo = casaService.getMaiorComodo(nome);
        return ResponseEntity.ok(maiorComodo);
    }

    /***
     * area de todos os comodos da casa
     * @param nome nome da casa
     * @return area do comodo
     */
    @GetMapping(value = "/areaComodos/{nome}")
    public ResponseEntity<String> areaComodos(@PathVariable String nome) {
        return ResponseEntity.ok(casaService.getAreaComodos(nome));
    }

}
