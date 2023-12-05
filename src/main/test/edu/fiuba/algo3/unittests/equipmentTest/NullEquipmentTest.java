package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.equipment.NullEquipment;


public class NullEquipmentTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        NullEquipment newEquipment = new NullEquipment();
        int energy = 20;

        energy = newEquipment.receiveAttack(energy);

        assertEquals(0, energy);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        NullEquipment newEquipment = new NullEquipment();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
