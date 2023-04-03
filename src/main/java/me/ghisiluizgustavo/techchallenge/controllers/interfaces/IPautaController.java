package me.ghisiluizgustavo.techchallenge.controllers.interfaces;

import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.models.dtos.ResultadoPautaDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

public interface IPautaController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    PautaDTO criarPauta(@RequestBody PautaDTO pautaDTO);

    @GetMapping("/consultar-resultado/{idPauta}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    ResultadoPautaDTO consultarResultado(@PathVariable Long idPauta);

    @PatchMapping("/fechar-pauta/{idPauta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void fecharPauta(@PathVariable Long idPauta);

}
