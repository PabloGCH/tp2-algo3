package edu.fiuba.algo3.unittests.equipmentTest;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.gladiator.equipment.Helmet;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import java.util.ArrayList;

public class HelmetTest {
    @Test void test01UpgradeReturnsHelmet(){
        Gladiator gladiator = new Gladiator("Example");

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
      @Test void test04ArmorIsNotComplete(){
        ArrayList<String> gladiators = new ArrayList<>();
        gladiators.add("Example");
        State fullArmor = new Active();
        Helmet newEquipment = new Helmet();

        fullArmor = newEquipment.win(fullArmor);

        assertFalse(fullArmor.isWinner(gladiators.get(0)).result(gladiators));
    }
    @Test
    public void test05ShowNameReturnsCorrectName(){
        Helmet helmet = new Helmet();
        assertEquals("helmet", helmet.showName());
    }
}
