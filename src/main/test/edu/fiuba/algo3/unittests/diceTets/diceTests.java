package edu.fiuba.algo3.unittests.diceTets;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Dice;
import org.junit.jupiter.api.Test;

public class diceTests {
    @Test void ReturnNumberBetween1And6() {
        //Arrange
        Dice dice = new Dice();

        //Act
        int number = dice.throwDice();

        //Assert
        assertTrue(number >= 1);
        assertTrue(number <= 6);
    }
}
