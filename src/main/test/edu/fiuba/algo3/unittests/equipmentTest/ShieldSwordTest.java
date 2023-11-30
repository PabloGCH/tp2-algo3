package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.equipment.Armor;
import edu.fiuba.algo3.modelo.equipment.ShieldSword;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class ShieldSwordTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(20, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        ShieldSword newEquipment = new ShieldSword();
        int energy = 20;

        energy = newEquipment.receiveAttack(energy);

        assertEquals(18, energy);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        ShieldSword newEquipment = new ShieldSword();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
