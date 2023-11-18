package edu.fiuba.algo3.unittests.energyTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;

public class EnergyTest {
    @Test void addEnergy() {
        //Arrange
        Energy energy = new Energy(10);
        //Act
        energy = energy.add(new Energy(5));
        int energyPoints = energy.getPoints();
        //Assert
        assertTrue(energyPoints == 15);
    }
    @Test void substractEnergy() {
        //Arrange
        Energy energy = new Energy(10);
        //Act
        energy = energy.substract(new Energy(5));
        int energyPoints = energy.getPoints();
        //Assert
        assertTrue(energyPoints == 5);
    }
}
