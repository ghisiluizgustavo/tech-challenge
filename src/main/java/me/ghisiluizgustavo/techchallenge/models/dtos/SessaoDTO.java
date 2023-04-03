package me.ghisiluizgustavo.techchallenge.models.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.time.LocalTime;

@Data
public class SessaoDTO {

    private Long id;
    private LocalTime duracao;
    private LocalTime dataFinal;

    @JsonIgnore
    private PautaDTO pauta;
}
