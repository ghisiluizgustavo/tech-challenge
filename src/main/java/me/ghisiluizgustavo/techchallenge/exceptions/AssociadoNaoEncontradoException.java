package me.ghisiluizgustavo.techchallenge.exceptions;

import me.ghisiluizgustavo.techchallenge.models.Associado;

public class AssociadoNaoEncontradoException extends RuntimeException {

    public AssociadoNaoEncontradoException(){
        super("Associado não encontrado");
    }
}
