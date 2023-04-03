package me.ghisiluizgustavo.techchallenge.exceptions;

public class CpfInvalidoException extends RuntimeException {
    public CpfInvalidoException(String cpfAssociado) {
        super("CPF inválido: " + cpfAssociado);
    }
}
