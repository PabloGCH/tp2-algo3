package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.equipment.Armor;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;

public class HelmetTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        //Act
        gladiator.upgrade();//NullEquipment upgrades to Helmet
        gladiator.upgrade();//Helmet upgrades to Armor
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;
        //Assert
        assertEquals(10, energyPoints);//Gladiator with Armor receives 10 damage fighting with a beast
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        //Arrange
        Helmet newEquipment = new Helmet();
        int energy = 20;
        //Act
        energy = newEquipment.receiveAttack(energy);
        //Assert
        assertEquals(5, energy);
    }

      @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        //Arrange
        Helmet newEquipment = new Helmet();
        //Act
        fullArmor = newEquipment.complete();
        //Assert
        assertFalse(fullArmor);
    }
}