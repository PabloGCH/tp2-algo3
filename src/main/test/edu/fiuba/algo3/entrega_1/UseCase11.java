package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class UseCase11 {
    @Test
    public void testGladiatorWithKeyUpgradeHasNoEffect(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;
        //Assert
        assertEquals(20, energyPoints);
        gladiator.upgrade();
        energyPoints = gladiator.getEnergy();;
        assertEquals(20, energyPoints);
    }
}
