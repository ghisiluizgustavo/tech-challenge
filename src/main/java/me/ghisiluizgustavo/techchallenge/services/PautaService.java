package me.ghisiluizgustavo.techchallenge.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.ghisiluizgustavo.techchallenge.exceptions.AssociadoJaVotouException;
import me.ghisiluizgustavo.techchallenge.exceptions.AssociadoNaoEncontradoException;
import me.ghisiluizgustavo.techchallenge.exceptions.NenhumaSessaoAbertaException;
import me.ghisiluizgustavo.techchallenge.exceptions.PautaNaoEncontradaException;
import me.ghisiluizgustavo.techchallenge.models.Pauta;
import me.ghisiluizgustavo.techchallenge.models.Sessao;
import me.ghisiluizgustavo.techchallenge.models.Voto;
import me.ghisiluizgustavo.techchallenge.models.dtos.*;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusEnum;
import me.ghisiluizgustavo.techchallenge.models.enums.VotoEnum;
import me.ghisiluizgustavo.techchallenge.repositories.AssociadoRepository;
import me.ghisiluizgustavo.techchallenge.repositories.PautaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class PautaService {

    @Autowired
    private PautaRepository pautaRepository;
    @Autowired
    private SessaoService sessaoService;

    @Autowired
    private AssociadoRepository associadoRepository;

    private ModelMapper mapper = new ModelMapper();

    public PautaDTO criarPauta(PautaDTO pautaDTO) {

        Pauta pauta = pautaRepository.save(mapper.map(pautaDTO, Pauta.class));
        Sessao sessao = sessaoService.criarSessao(pautaDTO.getSessao().get(0), pauta);
        pauta.setSessao(Collections.singletonList(sessao));

        return mapper.map(pauta, PautaDTO.class);
    }

    public void verificarSeAssociadoVotou(VotoDTO votoDTO) {
        List<Voto> votos = pautaRepository
                .findById(votoDTO.getIdPauta())
                .orElseThrow(PautaNaoEncontradaException::new)
                .getVotos();

        associadoRepository.findById(votoDTO.getIdAssociado()).orElseThrow(AssociadoNaoEncontradoException::new);

        votos.stream()
                .filter(v -> v.getIdAssociado().equals(votoDTO.getIdAssociado()))
                .findAny()
                .ifPresent(voto -> { throw new AssociadoJaVotouException(voto); });
    }

    public void verificarPautaFechada(VotoDTO votoDTO) {
        List<Sessao> sessoes = pautaRepository
                .findById(votoDTO.getIdPauta())
                .orElseThrow(PautaNaoEncontradaException::new)
                .getSessao();

        sessoes.stream()
                .filter(sessao -> sessao.getStatus().equals(StatusEnum.ABERTA))
                .findAny()
                .orElseThrow(NenhumaSessaoAbertaException::new);
    }

    public ResultadoPautaDTO consultarResultado(Long idPauta) {
        List<Voto> votos = pautaRepository
                .findById(idPauta)
                .orElseThrow(PautaNaoEncontradaException::new)
                .getVotos();

        ResultadoPautaDTO resultadoPauta = ResultadoPautaDTO.builder().build();

        resultadoPauta.setQuantiaSim(votos.stream().filter(v -> VotoEnum.SIM.equals(v.getVoto())).count());
        resultadoPauta.setQuantiaNao(votos.stream().filter(v -> VotoEnum.NAO.equals(v.getVoto())).count());

        if (resultadoPauta.getQuantiaSim() > resultadoPauta.getQuantiaNao()) {
            resultadoPauta.setResultado(ResultadoEnum.SIM);
            return resultadoPauta;
        }

        if(resultadoPauta.getQuantiaSim() < resultadoPauta.getQuantiaNao()) {
            resultadoPauta.setResultado(ResultadoEnum.NAO);
            return resultadoPauta;
        }

        resultadoPauta.setResultado(ResultadoEnum.EMPATE);
        return resultadoPauta;
    }

    public void fecharPauta(Long idPauta) {
        sessaoService.fecharPauta(idPauta);
    }
}
