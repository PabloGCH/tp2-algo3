package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Active;

public class activeTest {
    @Test
    void MoveShouldReturnDiceResult() {
        Active active = new Active();

        int number = active.move(1);

        assertEquals(1,number);
    }

    @Test
    void ChangesToTiredAndReturnsMove0() {
        Active active = new Active();

        var state = active.update(0);
        int number = state.move(1);

        assertEquals(0, number);
    }
}

