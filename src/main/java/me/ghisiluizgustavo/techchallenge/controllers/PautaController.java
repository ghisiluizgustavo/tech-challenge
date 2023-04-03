package me.ghisiluizgustavo.techchallenge.controllers;

import me.ghisiluizgustavo.techchallenge.controllers.interfaces.IPautaController;
import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.models.dtos.ResultadoPautaDTO;
import me.ghisiluizgustavo.techchallenge.services.PautaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/api/pauta")
public class PautaController implements IPautaController {

    @Autowired
    private PautaService pautaService;

    public PautaDTO criarPauta(PautaDTO pautaDTO){
        return pautaService.criarPauta(pautaDTO);
    }

    public ResultadoPautaDTO consultarResultado(Long idPauta) {
        return pautaService.consultarResultado(idPauta);
    }

    public void fecharPauta(Long idPauta) {
        pautaService.fecharPauta(idPauta);
    }

}
