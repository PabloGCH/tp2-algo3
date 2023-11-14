package edu.fiuba.algo3.entrega_1;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.points.Points;




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
        //Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        //Act
        //var equipment = gladiator.getEquipment();
        //Assert
        //assertTrue(equipment instanceof NullEquipment);
    }
}
