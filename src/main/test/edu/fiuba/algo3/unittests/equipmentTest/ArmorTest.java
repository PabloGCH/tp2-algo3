package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.equipment.Armor;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class ArmorTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        //Act
        gladiator.upgrade();//NullEquipment upgrades to Helmet
        gladiator.upgrade();//Helmet upgrades to Armor
        gladiator.upgrade();//Armor upgrades to ShieldSword
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;
        //Assert
        assertEquals(18, energyPoints);//Gladiator with ShieldSword receives 2 damage fighting with a beast
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        //Arrange
        Armor newEquipment = new Armor();
        int energy = 20;
        //Act
        energy = newEquipment.receiveAttack(energy);
        //Assert
        assertEquals(10, energy);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        //Arrange
        Armor newEquipment = new Armor();
        //Act
        fullArmor = newEquipment.complete();
        //Assert
        assertFalse(fullArmor);
    }
}