package edu.fiuba.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.SemiSenior;

public class semiSeniorTest {
    @Test void GoFromSemiSeniorToSenior() {
        //Arrange
        
        Energy energy = new Energy(10);
        SemiSenior semiSenior = new SemiSenior();
        //Act
        semiSenior.ascent();
        semiSenior.ascent();
        semiSenior.ascent();

        var newRank = semiSenior.ascent(); //for the four ascent the Semi Senior class must return
        var newEnergy = newRank.energyFromExperience(energy); //If you are Senior you should increase the given energy by 10
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(20, points);
    }

     @Test void IncreasesEnergyByFive() {
        //Arrange
        
        Energy energy = new Energy(10);
        SemiSenior semiSenior = new SemiSenior();
        //Act

        var newEnergy = semiSenior.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(15, points);
    }
}
