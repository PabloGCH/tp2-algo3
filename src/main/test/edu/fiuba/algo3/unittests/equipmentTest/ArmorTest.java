package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.equipment.Armor;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.equipment.Helmet;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ArmorTest {
    @Test
    public void test01UpgradeReturnsShieldSword(){
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
    @Test
    public void test02ReceiveAttackReturnsCorrectDamage(){
        Armor newEquipment = new Armor();
        int energy = 20;
        energy = newEquipment.receiveAttack(energy);
        assertEquals(10, energy);
    }
    @Test
    public void Test03WinReturnsSameState() {
        Armor armor = new Armor();
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position initialPosition = new Position(0, 0, 0);
        Position middlePosition = new Position(1, 0, 1);
        gladiator.positionate(initialPosition);

        State newState = armor.win(active);
        newState.tryToWin(gladiator, middlePosition);
        assertEquals(2, gladiator.move(5, 1));
    }
    @Test void armorIsNotComplete(){
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        State fullArmor = new Active();
        GameState gameState = new ActiveGame();
        Armor newEquipment = new Armor();

        fullArmor = newEquipment.win(fullArmor);

        assertFalse(fullArmor.isWinner(gladiators.get(0).getName()).result(gladiators));
    }
}
