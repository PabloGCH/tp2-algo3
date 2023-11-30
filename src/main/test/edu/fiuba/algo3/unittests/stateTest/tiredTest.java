package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.state.Tired;

public class tiredTest {
     @Test void MoveReturns0() {
        //Arrange
        
        Tired tired = new Tired();
        //Act

        int number = tired.move();

        //Assert
        assertTrue(number == 0);
    }

    @Test void ChangeToActiveShouldReturnMoveBetween1And6() {
        //Arrange
        int energy = 5;
        Tired tired = new Tired();

        //Act
        tired.update(energy);
        var state = tired.update(energy);
        int number = state.move();

        //Assert
        assertTrue(number >= 1);
        assertTrue(number <= 6);

    }
}

