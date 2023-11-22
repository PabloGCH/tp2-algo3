package edu.fiuba.algo3.diceTets;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.Rookie;

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
