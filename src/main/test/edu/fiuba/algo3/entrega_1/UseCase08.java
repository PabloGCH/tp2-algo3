package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;

public class UseCase08 {
    @Test
    public void tetsNewRange(){
        // Arrange

        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);
        // Act

        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();
        gladiator.move();

        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();

        // Assert

        assertEquals(25, energyPoints);


    }
}
