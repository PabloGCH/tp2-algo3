package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Injured;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Active;

import java.util.ArrayList;

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
    @Test
    public void test05DecideIfPlaysAgainSetSecondGladiatorInInitialIndex(){
        Active active = new Active();
        Gladiator gladiatorOne = new Gladiator("Example One");
        Gladiator gladiatorTwo = new Gladiator("Example Two");
        Gladiator gladiatorThree = new Gladiator("Example Three");
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        TurnDecider turnDecider = new TurnDecider(gladiators);

        assertEquals("Example One", gladiators.get(0).getName());
        active.decideIfPlaysAgain(turnDecider);
        assertEquals("Example Two", gladiators.get(0).getName());
    }
    @Test
    public void test06IsWinnerReturnsActiveGameState(){
        Active active = new Active();
        GameState gameState = active.isWinner();
        assertFalse(gameState.Finalized());
    }
    @Test
    public void test07UpdateTurnReturnsTurnPlusOne(){
        int turn = 1;
        Active active = new Active();
        int newTurn = active.updateTurn(turn);
        assertEquals(2, newTurn);
    }
    @Test
    public void test08FractureMakePlayerUnableToMove(){
        Active active = new Active();
        State state = active.fracture();
        assertEquals(0, state.move(1));
    }
}

