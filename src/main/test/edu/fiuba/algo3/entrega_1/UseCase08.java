package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;


public class UseCase08 {
    @Test
    public void tetsNewRange(){
        // Arrange

        Gladiator gladiator = new Gladiator();;
        // Act

        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        gladiator.turn();
        int energyPoints = gladiator.getEnergy();;

        // Assert

        assertEquals(5, energyPoints);


    }
}
