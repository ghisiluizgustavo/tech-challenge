package me.ghisiluizgustavo.techchallenge.services;

import me.ghisiluizgustavo.techchallenge.models.Sessao;
import me.ghisiluizgustavo.techchallenge.repositories.SessaoRepository;
import me.ghisiluizgustavo.techchallenge.util.CreateClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.time.LocalTime;

@ExtendWith(MockitoExtension.class)
public class SessaoServiceTest {

    private ModelMapper modelMapper = new ModelMapper();

    @Mock
    private SessaoService sessaoService;

    @Mock
    private SessaoRepository sessaoRepository;



    @Test
    void criarSessaoSucesso(){
        Mockito.when(sessaoRepository.save(Mockito.any(Sessao.class))).thenReturn(CreateClasses.newSessao());

        Sessao save = sessaoRepository.save(modelMapper.map(CreateClasses.newSessaoDTO(), Sessao.class));
        Assertions.assertEquals(CreateClasses.newSessao().getId(), save.getId());
    }

    @Test
    void criarSessaoSemDuracao(){
        Mockito.when(sessaoService.criarSessao(Mockito.any(), Mockito.any())).thenReturn(CreateClasses.newSessaoDefaultTime());

        Sessao sessao = sessaoService.criarSessao(CreateClasses.newSessaoDTO(), CreateClasses.newPautaSemSessao());

        Assertions.assertEquals(sessao.getDuracao(), LocalTime.of(0,1));
    }


}
