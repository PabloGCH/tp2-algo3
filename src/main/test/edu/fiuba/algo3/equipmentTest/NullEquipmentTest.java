package edu.fiuba.algo3.equipmentTest;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.energy.Energy;

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
        Energy energy = new Energy(20);

        energy = newEquipment.receiveAttack(energy);
        int energyPoints = energy.getPoints();

        assertEquals(0, energyPoints);
    }

    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        NullEquipment newEquipment = new NullEquipment();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
