package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.equipment.Helmet;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.position.Position;


public class NullEquipmentTest {
    @Test void test01UpgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), initialPosition);
        initialSquare.affect(gladiator);

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }
    @Test void test02ReceiveAttackReturnsCorrectDamage(){
        NullEquipment newEquipment = new NullEquipment();
        int energy = 20;

        energy = newEquipment.receiveAttack(energy);

        assertEquals(0, energy);
    }
    @Test
    public void test03WinReturnsSameState(){
        NullEquipment nullEquipment = new NullEquipment();
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Position middlePosition = new Position(1,0,1);
        gladiator.positionate(initialPosition);

        State newState = nullEquipment.win(active);
        newState.tryToWin(gladiator, middlePosition);
        assertEquals(2,gladiator.move(5,1));
    }
    @Test void armorIsNotComplete(){
        boolean fullArmor = true;
        NullEquipment newEquipment = new NullEquipment();

        fullArmor = newEquipment.complete();

        assertFalse(fullArmor);
    }
}
