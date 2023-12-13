package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.rank.Rookie;

public class rookieTest {
    @Test void GoFromRookieToSemiSenior() {
        int energy = 10;
        Rookie rookie = new Rookie();

        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();

        var newRank = rookie.ascent();
        int newEnergy = newRank.energyFromExperience(energy);

        assertEquals(15, newEnergy);
    }

     @Test void DoNotIncreaseAnyEnergy() {
        int energy = 10;
        Rookie rookie = new Rookie();

        int newEnergy = rookie.energyFromExperience(energy);

        assertEquals(10, newEnergy);
    }
    @Test
    public void showRankReturnsCorrectName(){
        Rookie rookie = new Rookie();
        assertEquals("Rookie", rookie.showRank());
    }
}