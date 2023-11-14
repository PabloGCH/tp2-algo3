package edu.fiuba.algo3.entrega_1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {
    @Test
    public void testGladiatorStartsWithCorrectEnergy() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        //Act
        Energy energy = gladiator.getEnergy();
        Points energyPoints = energy.getPoints();
        int amount = energyPoints.getAmount();
        //Assert
        assertTrue(amount == 20);
    }
    @Test
    public void testGladiatorStartsWithNullEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        //Act
        Equipment equipment = gladiator.getEquipment();
        //Assert
        assertTrue(equipment instanceof NullEquipment);
    }
}
