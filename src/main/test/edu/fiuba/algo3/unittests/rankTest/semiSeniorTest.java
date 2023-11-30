package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.SemiSenior;

public class semiSeniorTest {
    @Test void GoFromSemiSeniorToSenior() {
        
        Energy energy = new Energy(10);
        SemiSenior semiSenior = new SemiSenior();

        semiSenior.ascent();
        semiSenior.ascent();
        semiSenior.ascent();

        var newRank = semiSenior.ascent();
        var newEnergy = newRank.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(20, points);
    }

     @Test void IncreasesEnergyByFive() {
        Energy energy = new Energy(10);
        SemiSenior semiSenior = new SemiSenior();

        var newEnergy = semiSenior.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(15, points);
    }
}
