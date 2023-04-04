package me.ghisiluizgustavo.techchallenge.util;

import me.ghisiluizgustavo.techchallenge.models.Pauta;
import me.ghisiluizgustavo.techchallenge.models.Sessao;
import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.models.dtos.SessaoDTO;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusEnum;

import java.time.LocalTime;
import java.util.Collections;

public class CreateClasses {

    public static Sessao newSessao(){
        Sessao sessao = new Sessao();
        sessao.setId(1L);
        sessao.setStatus(StatusEnum.ABERTA);
        sessao.setDuracao(LocalTime.of(1, 0));
        return sessao;
    }

    public static Pauta newPauta(){
        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setTitulo("Pauta de teste");
        pauta.setSessao(Collections.singletonList(newSessao()));
        return pauta;
    }

    public static Pauta newPautaSemSessao(){
        Pauta pauta = new Pauta();
        pauta.setId(1L);
        pauta.setTitulo("Pauta de teste");
        return pauta;
    }

    public static PautaDTO newPautaDTO() {
        PautaDTO pautaDTO = new PautaDTO();
        pautaDTO.setTitulo("Pauta de teste");
        pautaDTO.setSessao(Collections.singletonList(newSessaoDTO()));
        return pautaDTO;
    }

    public static SessaoDTO newSessaoDTO() {
        SessaoDTO sessao = new SessaoDTO();
        sessao.setStatus(StatusEnum.ABERTA);
        sessao.setDuracao(LocalTime.of(1, 0));
        return sessao;
    }

    public static Sessao newSessaoDefaultTime() {
        Sessao sessao = new Sessao();
        sessao.setId(1L);
        sessao.setStatus(StatusEnum.ABERTA);
        sessao.setDuracao(LocalTime.of(0, 1));
        return sessao;
    }
}
