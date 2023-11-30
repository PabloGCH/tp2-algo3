package edu.fiuba.algo3.equipmentTest;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class KeyTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(20, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        Key newEquipment = new Key();
        Energy energy = new Energy(20);

        energy = newEquipment.receiveAttack(energy);
        int energyPoints = energy.getPoints();

        assertEquals(20, energyPoints);
    }

    @Test void armorIsComplete(){
        boolean fullArmor = false;
        Key newEquipment = new Key();

        fullArmor = newEquipment.complete();

        assertTrue(fullArmor);
    }
}
