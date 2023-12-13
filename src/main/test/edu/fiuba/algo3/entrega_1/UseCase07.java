package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase07 {
    @Test
    public void testLoseEnergyWithHelmet(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }
}
