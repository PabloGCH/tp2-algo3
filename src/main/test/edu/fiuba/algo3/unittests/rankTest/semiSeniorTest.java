package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.rank.SemiSenior;

public class semiSeniorTest {
    @Test void GoFromSemiSeniorToSenior() {
        //Arrange
        
        int energy = 10;
        SemiSenior semiSenior = new SemiSenior();

        semiSenior.ascent();
        semiSenior.ascent();
        semiSenior.ascent();

        var newRank = semiSenior.ascent();
        int newEnergy = newRank.energyFromExperience(energy);


        assertEquals(20, newEnergy);
    }

     @Test void IncreasesEnergyByFive() {
        int energy = 10;
        SemiSenior semiSenior = new SemiSenior();

        int newEnergy = semiSenior.energyFromExperience(energy);


        assertEquals(15, newEnergy);
    }
}
