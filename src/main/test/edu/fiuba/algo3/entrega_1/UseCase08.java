package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase08 {
    @Test
    public void tetsNewRange(){
        // Arrange

        Gladiator gladiator = new Gladiator();
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();

        // Act

        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();

        // Assert

        assertEquals(35, energyPoints);


    }
}
