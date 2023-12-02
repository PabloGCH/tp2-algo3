package edu.fiuba.algo3.entrega_1;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {

    @Test
    public void testGladiatorStartsWithCorrectEnergy() {
        //Arrange
        Gladiator gladiator = new Gladiator(); 
        Square initialSquare = new Initial(); 
        //Act
        initialSquare.receivePiece(gladiator); //Should start with 20 energy
        int energyPoints = gladiator.getEnergy();;
        //Assert
        assertEquals(20, energyPoints);
    }
    @Test
    public void testGladiatorStartsWithNullEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with NullEquipment
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator); //Should start with 20 energy
        //Act
        gladiator.fightWithBeast(); //With null equipment looses 20 energy
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertEquals(0, energyPoints);
    }
}
