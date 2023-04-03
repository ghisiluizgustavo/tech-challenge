package me.ghisiluizgustavo.techchallenge.models.dtos;

import lombok.Data;
import me.ghisiluizgustavo.techchallenge.models.enums.VotoEnum;

@Data
public class VotoDTO {

    private Long id;
    private VotoEnum voto;
    private AssociadoDTO associado;
    private PautaDTO pauta;

    public Long getIdAssociado(){
        return this.associado.getId();
    }

    public Long getIdPauta(){ return this.pauta.getId(); }

    public String getCpfAssociado() {
        return this.associado.getCpf();
    }
}
