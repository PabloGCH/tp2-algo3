package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.gladiator.rank.Rookie;

public class rookieTest {
    @Test void GoFromRookieToSemiSenior() {
        //Arrange
        
        Energy energy = new Energy(10);
        Rookie rookie = new Rookie();
        //Act
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();

        var newRank = rookie.ascent(); //for the eighth ascent the Semi Senior class must return
        var newEnergy = newRank.energyFromExperience(energy); ////If you are SemiSenior you should increase the given energy by 5
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(15, points);
    }

     @Test void DoNotIncreaseAnyEnergy() {
        //Arrange
        
        Energy energy = new Energy(10);
        Rookie rookie = new Rookie();
        //Act

        var newEnergy = rookie.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        //Assert
        assertEquals(10, points);
    }

}
