package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.Rookie;

public class rookieTest {
    @Test void GoFromRookieToSemiSenior() {
        Energy energy = new Energy(10);
        Rookie rookie = new Rookie();

        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();
        rookie.ascent();

        var newRank = rookie.ascent();
        var newEnergy = newRank.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(15, points);
    }

     @Test void DoNotIncreaseAnyEnergy() {
        Energy energy = new Energy(10);
        Rookie rookie = new Rookie();

        var newEnergy = rookie.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(10, points);
    }
}
