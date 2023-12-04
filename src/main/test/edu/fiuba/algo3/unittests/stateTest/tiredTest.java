package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Tired;

public class tiredTest {
     @Test void MoveReturns0() {
        Tired tired = new Tired();

        int number = tired.move(1);

        assertEquals(0, number);
    }

    @Test void ChangeToActiveShouldReturnMoveDiceResult() {
        int energy = 5;
        Tired tired = new Tired();

        tired.update(energy);
        var state = tired.update(energy);
        int number = state.move(1);

        assertEquals(1, number);
    }
}

