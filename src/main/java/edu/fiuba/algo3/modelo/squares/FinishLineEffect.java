package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.io.IOError;
import java.io.IOException;

public class FinishLineEffect implements Effect{
    private Square middleSquare;
    public FinishLineEffect(Square middleSquare) {
        this.middleSquare = middleSquare;
    }
    @Override
    public void affect(Gladiator aGladiator) {
        try {
            testException();
        } catch (IOException e) {
            this.middleSquare.receiveGladiator(aGladiator);
        }
    }

    private void testException() throws IOException {
        throw new IOException();
    }
}
