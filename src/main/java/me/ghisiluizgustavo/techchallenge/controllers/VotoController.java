package me.ghisiluizgustavo.techchallenge.controllers;

import me.ghisiluizgustavo.techchallenge.controllers.interfaces.IPautaController;
import me.ghisiluizgustavo.techchallenge.controllers.interfaces.IVotoController;
import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.models.dtos.VotoDTO;
import me.ghisiluizgustavo.techchallenge.services.PautaService;
import me.ghisiluizgustavo.techchallenge.services.VotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/votar")
public class VotoController implements IVotoController {

    @Autowired
    private VotoService votoService;


    public VotoDTO votar(VotoDTO votoDTO) {
        return votoService.votar(votoDTO);
    }
}
