package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.state.Active;
import edu.fiuba.algo3.modelo.state.Injured;

public class injuredTest {
     @Test
     void MoveReturns0() {
        Injured injured = new Injured();

        int number = injured.move();

        assertTrue(number == 0);
    }

    @Test
    void ChangeToActiveShouldReturnMoveBetween1And6() {
        int energy = 0;
        Injured injured = new Injured();

        injured.update(energy);
        var state = injured.update(energy);
        int number = state.move();

        assertTrue(number >= 1);
        assertTrue(number <= 6);
    }
}
