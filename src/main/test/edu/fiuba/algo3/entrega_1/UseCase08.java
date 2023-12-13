package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase08 {
    @Test
    public void testNewRange(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        gladiator.move(10,1);
        int energyPoints = gladiator.getEnergy();

        assertEquals(25, energyPoints);
    }
}
