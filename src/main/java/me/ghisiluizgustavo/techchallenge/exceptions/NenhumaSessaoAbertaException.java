package me.ghisiluizgustavo.techchallenge.exceptions;

public class NenhumaSessaoAbertaException extends RuntimeException {

    public NenhumaSessaoAbertaException() {
        super("Nenhuma sessao aberta encontrada para esta pauta!");
    }
}
