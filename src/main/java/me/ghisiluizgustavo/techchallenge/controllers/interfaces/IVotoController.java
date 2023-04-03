package me.ghisiluizgustavo.techchallenge.controllers.interfaces;

import me.ghisiluizgustavo.techchallenge.models.dtos.VotoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public interface IVotoController {

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    VotoDTO votar(@RequestBody VotoDTO votoDTO);
}
