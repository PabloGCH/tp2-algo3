package edu.fiuba.algo3.unittests.stateTest;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.gladiator.state.Tired;
import edu.fiuba.algo3.modelo.gladiator.state.Winner;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class winnerTests {
    @Test
    public void test01IsWinnerReturnsFinishedByWinningState(){
        Winner winner = new Winner();
        GameState gameState = winner.isWinner();
        assertTrue(gameState.Finalized());
    }
    @Test
    public void test02TtyToWinDoesNotSendGladiatorToMiddle(){
        Winner winner = new Winner();
        Gladiator gladiator = new Gladiator("Example");
        Position initialPosition = new Position(0,0,0);
        gladiator.positionate(initialPosition);
        Position middlePosition = new Position(5,5,5);
        winner.tryToWin(gladiator,middlePosition);
        assertEquals(1, gladiator.move(5,1));
    }
    @Test
    public void test03DecideIfPlaysAgainSetSecondGladiatorInInitialIndex(){
        Winner winner = new Winner();
        Gladiator gladiatorOne = new Gladiator("Example One");
        Gladiator gladiatorTwo = new Gladiator("Example Two");
        Gladiator gladiatorThree = new Gladiator("Example Three");
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        TurnDecider turnDecider = new TurnDecider(gladiators);

        assertEquals("Example One", gladiators.get(0).getName());
        winner.decideIfPlaysAgain(turnDecider);
        assertEquals("Example Two", gladiators.get(0).getName());
    }
    @Test
    public void test04UpdateTurnReturnsTurnPlusOne(){
        int turn = 1;
        Winner winner = new Winner();
        int newTurn = winner.updateTurn(turn);
        assertEquals(2, newTurn);
    }
    @Test
    public void test05UpdateReturnsWinnerState(){
        Winner winner = new Winner();
        State state = winner.update(10);
        GameState gameState = state.isWinner();
        assertTrue(gameState.Finalized());
    }
    @Test
    public void test06RunEffectIsNotApplied(){
        Winner winner = new Winner();
        Gladiator gladiator = new Gladiator("Example");
        assertEquals(20, gladiator.getEnergy());
        winner.runEffect(new Food(), gladiator);
        assertEquals(20, gladiator.getEnergy());
    }
}
