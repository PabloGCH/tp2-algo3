package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase06 {
    @Test
    public void testGladiatorGetsShieldSword(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(18, energyPoints);
    }
}
