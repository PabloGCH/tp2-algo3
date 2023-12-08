package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.equipment.Armor;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class ArmorTest {
    @Test void upgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position);
        initialSquare.affect(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(18, energyPoints);
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        Armor newEquipment = new Armor();
        int energy = 20;
        energy = newEquipment.receiveAttack(energy);
        assertEquals(10, energy);
    }

}
