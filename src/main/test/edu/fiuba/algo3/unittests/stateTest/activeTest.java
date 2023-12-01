package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.gladiator.state.Active;

public class activeTest {
    @Test void MoveShouldReturnANumberBetween1And6() {
        //Arrange
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        Active active = new Active(dice);
        //Act

        int number = active.move();

        //Assert
        assertTrue(number >= 1);
        assertTrue(number <= 6);
    }

@Test void ChangesToTiredAndReturnsMove0() {
        //Arrange
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        Energy energy = new Energy(0);
        Active active = new Active(dice);

        //Act

        var state = active.update(energy);
        int number = state.move();

        //Assert
        assertTrue(number == 0);

    }
}

