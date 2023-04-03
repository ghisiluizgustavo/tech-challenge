package me.ghisiluizgustavo.techchallenge.exceptions;

import me.ghisiluizgustavo.techchallenge.models.Voto;

public class AssociadoJaVotouException extends RuntimeException {

    public AssociadoJaVotouException(Voto voto) {
        super("Associado já votou na pauta: " + voto.getPauta().getTitulo());
    }
}
