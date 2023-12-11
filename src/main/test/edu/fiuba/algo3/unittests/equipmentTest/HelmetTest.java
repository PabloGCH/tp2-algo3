package edu.fiuba.algo3.unittests.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.equipment.Helmet;
import edu.fiuba.algo3.modelo.gladiator.equipment.ShieldSword;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class HelmetTest {
    @Test void test01UpgradeReturnsHelmet(){
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
    @Test void test02ReceiveAttackReturnsCorrectDamage(){
        Helmet newEquipment = new Helmet();
        int energy = 20;
        energy = newEquipment.receiveAttack(energy);
        assertEquals(5, energy);
    }

    @Test
    public void test03WinReturnsSameState(){
        Helmet helmet = new Helmet();
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        Position initialPosition = new Position(0,0,0);
        Position middlePosition = new Position(1,0,1);
        gladiator.positionate(initialPosition);

        State newState = helmet.win(active);
        newState.tryToWin(gladiator, middlePosition);
        assertEquals(2,gladiator.move(5,1));
    }
      @Test void armorIsNotComplete(){
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        State fullArmor = new Active();
        GameState gameState = new ActiveGame();
        Helmet newEquipment = new Helmet();

        fullArmor = newEquipment.win(fullArmor);

        assertFalse(fullArmor.isWinner(gladiators.get(0).getName()).result(gladiators));
    }
}
