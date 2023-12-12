package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.gladiator.state.Tired;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.state.Injured;

import java.util.ArrayList;

public class injuredTest {
     @Test
     void test01MoveReturns0() {
        Injured injured = new Injured();

        int number = injured.move(1);

        assertEquals(0,number);
    }

    @Test
    void test02ChangeToActiveShouldReturnMoveDiceResult() {
        int energy = 0;
        Injured injured = new Injured();

        injured.update(energy);
        var state = injured.update(energy);
        int number = state.move(1);

        assertEquals(1,number);
    }
    @Test
    public void test03DecideIfPlaysAgainSetSecondGladiatorInInitialIndex(){
        Injured injured = new Injured();
        Gladiator gladiatorOne = new Gladiator("Example One");
        Gladiator gladiatorTwo = new Gladiator("Example Two");
        Gladiator gladiatorThree = new Gladiator("Example Three");
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        TurnDecider turnDecider = new TurnDecider(gladiators);

        assertEquals("Example One", gladiators.get(0).getName());
        injured.decideIfPlaysAgain(turnDecider);
        assertEquals("Example Two", gladiators.get(0).getName());
    }
    @Test
    public void test04IsWinnerReturnsActiveGameState(){
        Injured injured = new Injured();
        GameState gameState = injured.isWinner("Example");
        assertFalse(gameState.Finalized());
    }
    @Test
    public void test05UpdateTurnReturnsTurnPlusOne(){
        int turn = 1;
        Injured injured = new Injured();
        int newTurn = injured.updateTurn(turn);
        assertEquals(2, newTurn);
    }
    @Test
    public void test06RunEffectIsNotApplied(){
        Injured injured = new Injured();
        Gladiator gladiator = new Gladiator("Example");
        assertEquals(20, gladiator.getEnergy());
        injured.runEffect(new Food(), gladiator);
        assertEquals(20, gladiator.getEnergy());
    }
    @Test
    public void test06FractureReturnsSameState(){
        int energy = 0;
        Injured injured = new Injured();
        State newState = injured.fracture();

        int number = newState.move(1);
        assertEquals(0,number);

        newState.update(energy);
        State newStateTwo = newState.update(energy);

        number = newStateTwo.move(1);
        assertEquals(1,number);
    }
    @Test
    public void test07ShowStateReturnsCorrectName(){
        Injured injured = new Injured();
        assertEquals("Injured", injured.showState());
    }
}
