package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.rank.Senior;

public class seniorTest {
     @Test void ReturnSeniorNoMatterHowManyTimesAscentIsUsed() {
        Energy energy = new Energy(10);
        Senior senior = new Senior();

        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();

        var newRank = senior.ascent();
        var newEnergy = newRank.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(20, points);
    }

     @Test void IncreasesEnergyByTen() {
        Energy energy = new Energy(10);
        Senior senior = new Senior();

        var newEnergy = senior.energyFromExperience(energy);
        int points = newEnergy.getPoints();

        assertEquals(20, points);
    }
}
