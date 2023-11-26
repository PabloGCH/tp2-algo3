package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.io.IOError;
import java.io.IOException;

public class FinishLineEffect implements Effect{

    @Override
    public void affect(Gladiator aGladiator) {
        try {
            testException();
        } catch (IOException e) {
            aGladiator.backToTheMiddle();
        }
    }

    private void testException() throws IOException {
        throw new IOException();
    }
}
