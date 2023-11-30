package edu.fiuba.algo3.unittests.rankTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.rank.Senior;

public class seniorTest {
     @Test void ReturnSeniorNoMatterHowManyTimesAscentIsUsed() {
        int energy = 10;
        Senior senior = new Senior();

        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();
        senior.ascent();

        var newRank = senior.ascent();
        int newEnergy = newRank.energyFromExperience(energy);

        assertEquals(20, newEnergy);
    }

     @Test void IncreasesEnergyByTen() {
        int energy = 10;
        Senior senior = new Senior();

        int newEnergy = senior.energyFromExperience(energy);

        assertEquals(20, newEnergy);
    }
}
