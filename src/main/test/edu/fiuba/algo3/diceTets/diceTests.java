package edu.fiuba.algo3.diceTets;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import org.junit.jupiter.api.Test;

public class diceTests {
    @Test void ReturnNumberBetween1And6() {
        //Arrange
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();

        //Act
        int number = dice.throwNumber();

        //Assert
        assertTrue(number >= 1);
        assertTrue(number <= 6);
    }
}
