package edu.fiuba.algo3.gladiatorTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class GladiatorTest {
    @Test void energyUpdatedCorrectlyAfterEating() {
        //Arrange
        Gladiator gladiator = new Gladiator();
        //Act
        gladiator.eat();
        int energyPoints = gladiator.getEnergy().getPoints();
        //Assert
        //Starts with 20 energy, 15 is added after eating
        assertTrue(energyPoints == 35);
    }
    @Test void energyUpdatedCorrectlyAfterEatingTwice() {
        //Arrange
        Gladiator gladiator = new Gladiator();
        //Act
        gladiator.eat();
        gladiator.eat();
        int energyPoints = gladiator.getEnergy().getPoints();
        //Assert
        //Starts with 20 energy, 15 is added after eating
        assertTrue(energyPoints == 50);
    }
}
