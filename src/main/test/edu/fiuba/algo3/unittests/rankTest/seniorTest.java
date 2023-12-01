package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.rank.Senior;

public class seniorTest {
     @Test void ReturnSeniorNoMatterHowManyTimesAscentIsUsed() {
        //Arrange
        
        int energy = 10;
        Senior senior = new Senior();
        //Act
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();

        var newRank = senior.ascent(); //will always end up returning Senior
        int newEnergy = newRank.energyFromExperience(energy); //If you are Senior you should increase the given energy by 10

        //Assert
        assertEquals(20, newEnergy);
    }

     @Test void IncreasesEnergyByTen() {
        //Arrange
        
        int energy = 10;
        Senior senior = new Senior();
        //Act

        int newEnergy = senior.energyFromExperience(energy);

        //Assert
        assertEquals(20, newEnergy);
    }
}
