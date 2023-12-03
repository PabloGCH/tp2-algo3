package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase04 {
    @Test
    public void testIncreasedEnergyPerMeal(){
        Gladiator gladiator = new Gladiator();
        gladiator.eat();

        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 15);
    }
}
