package edu.fiuba.algo3.equipmentTest;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.Helmet;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;

public class HelmetTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(10, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        Helmet newEquipment = new Helmet();
        Energy energy = new Energy(20);

        energy = newEquipment.receiveAttack(energy);
        int energyPoints = energy.getPoints();

        assertEquals(5, energyPoints);
    }

      @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        Helmet newEquipment = new Helmet();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
