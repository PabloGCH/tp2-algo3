package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.gladiator.equipment.ShieldSword;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class ShieldSwordTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        //Act
        gladiator.upgrade();//NullEquipment upgrades to Helmet
        gladiator.upgrade();//Helmet upgrades to Armor
        gladiator.upgrade();//Armor upgrades to ShieldSword
        gladiator.upgrade();//ShieldSword upgrades to Key
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertEquals(20, energyPoints);//Gladiator with Key receives 0 damage fighting with a beast
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        //Arrange
        ShieldSword newEquipment = new ShieldSword();
        int energy = 20;
        //Act
        energy = newEquipment.receiveAttack(energy);
        //Assert
        assertEquals(18, energy);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        //Arrange
        ShieldSword newEquipment = new ShieldSword();
        //Act
        fullArmor = newEquipment.complete();
        //Assert
        assertFalse(fullArmor);
    }
}
