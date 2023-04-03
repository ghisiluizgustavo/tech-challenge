package me.ghisiluizgustavo.techchallenge.models.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoPautaDTO {

    private ResultadoEnum resultado;
    private Long quantiaSim;
    private Long quantiaNao;
}
