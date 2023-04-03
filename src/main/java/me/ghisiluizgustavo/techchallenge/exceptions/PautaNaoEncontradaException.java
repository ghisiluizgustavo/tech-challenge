package me.ghisiluizgustavo.techchallenge.exceptions;


public class PautaNaoEncontradaException extends RuntimeException {

    public PautaNaoEncontradaException(){
        super("Pauta não encontrada");
    }
}
