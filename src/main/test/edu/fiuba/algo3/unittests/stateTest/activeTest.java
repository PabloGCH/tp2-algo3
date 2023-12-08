package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Injured;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Active;

public class activeTest {
    @Test
    void test01MoveShouldReturnDiceResult() {
        Active active = new Active();

        int number = active.move(1);

        assertEquals(1,number);
    }
    @Test
    void test02IfEnergyEqualsZeroUpdateChangesToTiredAndReturnsMoveZero() {
        Active active = new Active();

        var state = active.update(0);
        int number = state.move(1);

        assertEquals(0, number);
    }
    @Test
    void test03RunEffectAffectsGladiator(){
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");

        active.runEffect(new Food(), gladiator);

        assertEquals(35, gladiator.getEnergy());
    }
    @Test
    void test04getIntoBacchanaliaReturnsInTheBacchanaliaState(){
        Active active = new Active();
        Gladiator gladiator = new Gladiator("Example");
        State newState = active.getIntoBacchanalia(gladiator);
        int energyExpectedAfterDrinking = 16;
        int number = newState.move(1);

        assertEquals(0,number);
        assertEquals(energyExpectedAfterDrinking, gladiator.getEnergy());
    }
}

