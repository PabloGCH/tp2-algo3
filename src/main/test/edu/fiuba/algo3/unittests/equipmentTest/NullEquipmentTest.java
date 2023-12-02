package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.equipment.NullEquipment;

public class NullEquipmentTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        //Act
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertEquals(5, energyPoints);//Gladiator with Helmet receives 15 damage fighting with a beast
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        //Arrange
        NullEquipment newEquipment = new NullEquipment();
        int energy = 20;
        //Act
        energy = newEquipment.receiveAttack(energy);
        //Assert
        assertEquals(0, energy);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        //Arrange
        NullEquipment newEquipment = new NullEquipment();
        //Act
        fullArmor = newEquipment.complete();
        //Assert
        assertFalse(fullArmor);
    }
}
