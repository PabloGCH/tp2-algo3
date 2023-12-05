package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.equipment.Helmet;
import edu.fiuba.algo3.modelo.squares.Position;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

public class HelmetTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), initialPosition);
        initialSquare.affect(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(10, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        Helmet newEquipment = new Helmet();
        int energy = 20;
        energy = newEquipment.receiveAttack(energy);
        assertEquals(5, energy);
    }

      @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        Helmet newEquipment = new Helmet();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
