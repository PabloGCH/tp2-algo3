package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Injured;

public class injuredTest {
     @Test
     void MoveReturns0() {
        Injured injured = new Injured();

        int number = injured.move(1);

        assertEquals(0,number);
    }

    @Test
    void ChangeToActiveShouldReturnMoveDiceResult() {
        int energy = 0;
        Injured injured = new Injured();

        injured.update(energy);
        var state = injured.update(energy);
        int number = state.move(1);

        assertEquals(1,number);
    }
}
