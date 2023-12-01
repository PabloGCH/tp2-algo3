package edu.fiuba.algo3.unittests.energyTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.energy.Energy;

public class EnergyTest {
    @Test void addEnergy() {
        Energy energy = new Energy(10);

        energy = energy.add(new Energy(5));
        int energyPoints = energy.getPoints();

        assertTrue(energyPoints == 15);
    }
    @Test void substractEnergy() {

        Energy energy = new Energy(10);

        energy = energy.substract(new Energy(5));
        int energyPoints = energy.getPoints();

        assertTrue(energyPoints == 5);
    }
}
