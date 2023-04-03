package me.ghisiluizgustavo.techchallenge.exceptions;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@ResponseBody
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ PautaNaoEncontradaException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CustomErrorResponse handlePautaNaoEncontrada(PautaNaoEncontradaException ex) {
        return CustomErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler({ AssociadoJaVotouException.class })
    @ResponseStatus(HttpStatus.CONFLICT)
    protected CustomErrorResponse handleAssociadoJaVotou(AssociadoJaVotouException ex) {
        return CustomErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .build();
    }

    @ExceptionHandler({ AssociadoNaoEncontradoException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CustomErrorResponse handleAssociadoNaoEncontrado(AssociadoNaoEncontradoException ex) {
        return CustomErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler({ NenhumaSessaoAbertaException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CustomErrorResponse handleSessaoAbertaNaoEncontrada(NenhumaSessaoAbertaException ex) {
        return CustomErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

    @ExceptionHandler({ CpfInvalidoException.class })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected CustomErrorResponse handleCpfInvalido(CpfInvalidoException ex) {
        return CustomErrorResponse.builder()
                .error(ex.getMessage())
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.NOT_FOUND.value())
                .build();
    }

}
