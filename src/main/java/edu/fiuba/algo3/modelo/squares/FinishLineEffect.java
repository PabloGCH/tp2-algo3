package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.io.IOError;
import java.io.IOException;

public class FinishLineEffect implements Effect{
    private Square middleSquare;
    private Square lastSquare;
    public FinishLineEffect(Square middleSquare, Square lastSquare) {
        this.middleSquare = middleSquare;
        this.lastSquare = lastSquare;
    }
    @Override
    public void affect(Gladiator aGladiator) {
        try {
            testException();
        } catch (IOException e) {
            this.middleSquare.receivePiece(aGladiator);
            this.lastSquare.removePiece(aGladiator);
        }
    }

    private void testException() throws IOException {
        throw new IOException();
    }
}
