package edu.fiuba.algo3.unittests.diceTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Dice;
import org.junit.jupiter.api.Test;

public class diceTests {
    @Test void ReturnNumberBetween1And6() {
        Dice dice = new Dice();

        int number = dice.throwDice();

        assertTrue(number >= 1);
        assertTrue(number <= 6);
    }
}
