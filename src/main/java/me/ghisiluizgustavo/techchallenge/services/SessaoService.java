package me.ghisiluizgustavo.techchallenge.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.ghisiluizgustavo.techchallenge.exceptions.PautaNaoEncontradaException;
import me.ghisiluizgustavo.techchallenge.models.Pauta;
import me.ghisiluizgustavo.techchallenge.models.Sessao;
import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.models.dtos.SessaoDTO;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusEnum;
import me.ghisiluizgustavo.techchallenge.repositories.SessaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SessaoService {

    @Autowired
    private SessaoRepository sessaoRepository;
    private ModelMapper mapper = new ModelMapper();
    public Sessao criarSessao(SessaoDTO sessaoDTO, Pauta pauta) {
        Sessao sessao = mapper.map(sessaoDTO, Sessao.class);
        sessao.setPauta(pauta);

        if (null == sessaoDTO.getDuracao() || sessaoDTO.getDuracao().equals(LocalTime.MIDNIGHT)){
            sessao.setDuracao(LocalTime.of(0, 1));
        }

        LocalTime duracao = sessao.getDuracao();

        sessao.setDataFinal(
                LocalTime
                        .now()
                        .plusHours(duracao.getHour())
                        .plusMinutes(duracao.getMinute())
        );

        sessao.setPauta(pauta);

        return sessaoRepository.save(sessao);
    }

    public void fecharPauta(Long idPauta) {
        Sessao sessao = sessaoRepository.findByPauta_Id(idPauta).orElseThrow(PautaNaoEncontradaException::new);
        sessao.setStatus(StatusEnum.FECHADA);
        sessaoRepository.save(sessao);
    }
}
