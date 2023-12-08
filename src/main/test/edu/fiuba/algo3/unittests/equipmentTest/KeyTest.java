package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.equipment.Armor;
import edu.fiuba.algo3.modelo.gladiator.equipment.Key;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class KeyTest {
    @Test void Test01UpgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), initialPosition);
        initialSquare.affect(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(20, energyPoints);
    }
    @Test void Test02ReceiveAttackReturnsCorrectDamage(){
        Key newEquipment = new Key();
        int energy = 20;
        energy = newEquipment.receiveAttack(energy);
        assertEquals(20, energy);
    }
    @Test
    public void test03WinReturnsSameState(){
        Key Key = new Key();
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Position middlePosition = new Position(1,0,1);
        gladiator.positionate(initialPosition);

        State newState = Key.win(active);
        newState.tryToWin(gladiator, middlePosition);
        assertEquals(1,gladiator.move(5,1));
    }
    @Test void armorIsComplete(){
        boolean fullArmor = false;
        Key newEquipment = new Key();

        fullArmor = newEquipment.complete();

        assertTrue(fullArmor);
    }
}
