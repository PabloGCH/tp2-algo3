package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;

public class UseCase07 {
    @Test
    public void testLoseEnergyWhithHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy

        //Act
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;
        //Assert
        assertEquals(-15, energyPoints);
    }
}
