package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.rank.SemiSenior;

public class semiSeniorTest {
    @Test void GoFromSemiSeniorToSenior() {
        //Arrange
        
        int energy = 10;
        SemiSenior semiSenior = new SemiSenior();
        //Act
        semiSenior.ascent();
        semiSenior.ascent();
        semiSenior.ascent();

        var newRank = semiSenior.ascent(); //for the four ascent the Semi Senior class must return
        int newEnergy = newRank.energyFromExperience(energy); //If you are Senior you should increase the given energy by 10

        //Assert
        assertEquals(20, newEnergy);
    }

     @Test void IncreasesEnergyByFive() {
        //Arrange
        
        int energy = 10;
        SemiSenior semiSenior = new SemiSenior();
        //Act

        int newEnergy = semiSenior.energyFromExperience(energy);

        //Assert
        assertEquals(15, newEnergy);
    }
}
