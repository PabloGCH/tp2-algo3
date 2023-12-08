package edu.fiuba.algo3.unittests.stateTest;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Winner;
import edu.fiuba.algo3.modelo.position.Position;
import org.junit.jupiter.api.Test;

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
}
