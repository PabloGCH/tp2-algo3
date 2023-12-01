package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.gladiator.rank.Senior;

public class seniorTest {
     @Test void ReturnSeniorNoMatterHowManyTimesAscentIsUsed() {
        //Arrange
        
        Energy energy = new Energy(10);
        Senior senior = new Senior();
        //Act
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();

        var newRank = senior.ascent(); //will always end up returning Senior
        var newEnergy = newRank.energyFromExperience(energy); //If you are Senior you should increase the given energy by 10
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(20, points);
    }

     @Test void IncreasesEnergyByTen() {
        //Arrange
        
        Energy energy = new Energy(10);
        Senior senior = new Senior();
        //Act

        var newEnergy = senior.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(20, points);
    }
}
