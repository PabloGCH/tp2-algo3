package edu.fiuba.algo3.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.equipment.NullEquipment;

public class NullEquipmentTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        gladiator.upgrade();
        gladiator.fightWithBeast();
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(5, energyPoints);//Gladiator with Helmet receives 15 damage fighting with a beast
    }

}
