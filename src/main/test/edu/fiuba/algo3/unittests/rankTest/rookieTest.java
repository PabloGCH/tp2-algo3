package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.rank.Rookie;

public class rookieTest {
    @Test void GoFromRookieToSemiSenior() {
        //Arrange
        
        int energy = 10;
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
        int newEnergy = newRank.energyFromExperience(energy); ////If you are SemiSenior you should increase the given energy by 5

        //Assert
        assertEquals(15, newEnergy);
    }

     @Test void DoNotIncreaseAnyEnergy() {
        //Arrange
        
        int energy = 10;
        Rookie rookie = new Rookie();
        //Act

        int newEnergy = rookie.energyFromExperience(energy);

        //Assert
        assertEquals(10, newEnergy);
    }

}
