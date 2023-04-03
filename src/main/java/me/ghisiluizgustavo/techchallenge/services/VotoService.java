package me.ghisiluizgustavo.techchallenge.services;

import me.ghisiluizgustavo.techchallenge.exceptions.CpfInvalidoException;
import me.ghisiluizgustavo.techchallenge.models.Voto;
import me.ghisiluizgustavo.techchallenge.models.dtos.StatusCPF;
import me.ghisiluizgustavo.techchallenge.models.dtos.VotoDTO;
import me.ghisiluizgustavo.techchallenge.models.enums.StatusAssociadoEnum;
import me.ghisiluizgustavo.techchallenge.repositories.VotoRepository;
import me.ghisiluizgustavo.techchallenge.services.feign.ValidadorCpf;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private PautaService pautaService;

    @Autowired
    private ValidadorCpf validadorCpf;

    private ModelMapper mapper = new ModelMapper();

    public VotoDTO votar(VotoDTO votoDTO) {
        pautaService.verificarPautaFechada(votoDTO);
        pautaService.verificarSeAssociadoVotou(votoDTO);

        StatusAssociadoEnum status = validadorCpf.validarCpf(votoDTO.getCpfAssociado()).getStatus();

        if (status.equals(StatusAssociadoEnum.UNABLE_TO_VOTE)){
            throw new CpfInvalidoException(votoDTO.getCpfAssociado());
        }

        Voto save = votoRepository.save(mapper.map(votoDTO, Voto.class));
        return mapper.map(save, VotoDTO.class);
    }
}
