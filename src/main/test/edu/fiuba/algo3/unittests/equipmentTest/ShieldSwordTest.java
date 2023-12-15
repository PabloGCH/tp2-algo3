package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.equipment.Armor;
import edu.fiuba.algo3.modelo.gladiator.equipment.ShieldSword;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShieldSwordTest {
    @Test void test01UpgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(20, energyPoints);
    }
    @Test void test02ReceiveAttackReturnsCorrectDamage(){
        ShieldSword newEquipment = new ShieldSword();
        int energy = 20;

        energy = newEquipment.receiveAttack(energy);

        assertEquals(18, energy);
    }
    @Test
    public void test03WinReturnsSameState(){
        ShieldSword shieldSword = new ShieldSword();
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0,0,0);
        Position middlePosition = new Position(1,0,1);
        gladiator.positionate(initialPosition);

        State newState = shieldSword.win(active);
        newState.tryToWin(gladiator, middlePosition);
        assertEquals(2,gladiator.move(5,1));
    }
    @Test void test04ArmorIsNotComplete(){
        ArrayList<String> gladiators = new ArrayList<>();
        gladiators.add("Example");
        State fullArmor = new Active();
        ShieldSword newEquipment = new ShieldSword();

        fullArmor = newEquipment.win(fullArmor);

        assertFalse(fullArmor.isWinner(gladiators.get(0)).result(gladiators));
    }
    @Test
    public void test05ShowNameReturnsCorrectName(){
        ShieldSword shieldSword = new ShieldSword();
        assertEquals("shield-and-sword", shieldSword.showName());
    }
}
