package me.ghisiluizgustavo.techchallenge.services;


import me.ghisiluizgustavo.techchallenge.models.Pauta;
import me.ghisiluizgustavo.techchallenge.models.dtos.PautaDTO;
import me.ghisiluizgustavo.techchallenge.repositories.PautaRepository;
import me.ghisiluizgustavo.techchallenge.util.CreateClasses;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;


@ExtendWith(MockitoExtension.class)
public class PautaServiceTest {


    @Mock
    private PautaRepository pautaRepository;

    private ModelMapper modelMapper = new ModelMapper();


    @Test
    void criarPautaSucesso(){
        PautaDTO pautaDTO = CreateClasses.newPautaDTO();
        Pauta pauta = modelMapper.map(pautaDTO, Pauta.class);

        Mockito.when(pautaRepository.save(pauta)).thenReturn(pauta);

        Pauta save = pautaRepository.save(pauta);
        Assertions.assertEquals(pauta.getTitulo(), save.getTitulo());
    }

}
