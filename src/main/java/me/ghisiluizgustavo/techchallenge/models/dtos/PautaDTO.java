package me.ghisiluizgustavo.techchallenge.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class PautaDTO {

    private Long id;
    private String titulo;
    private List<SessaoDTO> sessao;
    private List<VotoDTO> votos;
}
