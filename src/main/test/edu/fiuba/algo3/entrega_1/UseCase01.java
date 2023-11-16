package edu.fiuba.algo3.entrega_1;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {

    @Test
    public void testGladiatorStartsWithCorrectEnergy() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        //Act
        initialSquare.receiveGladiator(gladiator);
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertTrue(energyPoints == 20);
    }
    @Test
    public void testGladiatorStartsWithNullEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with NullEquipment
        //Act
        var equipment = gladiator.getEquipment();
        //Assert
        assertTrue(equipment instanceof NullEquipment);
    }
}
