package edu.fiuba.algo3.unittests.stateTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.state.Tired;
import java.util.ArrayList;

public class tiredTest {
     @Test void test01MoveReturns0() {
        Tired tired = new Tired();

        int number = tired.move(1);

        assertEquals(0, number);
    }

    @Test void test02UpdateChangeToActiveAndReturnMoveDiceResult() {
        int energy = 5;
        Tired tired = new Tired();

        var state = tired.update(energy);
        int number = state.move(1);

        assertEquals(1, number);
    }
    @Test void test02UpdateWithoutEnergyStaysInTiredState() {
        int energy = 0;
        Tired tired = new Tired();

        var state = tired.update(energy);
        int number = state.move(1);

        assertEquals(0, number);
    }
    @Test
    public void test03DecideIfPlaysAgainSetSecondGladiatorInInitialIndex(){
        Tired tired = new Tired();
        Gladiator gladiatorOne = new Gladiator("Example One");
        Gladiator gladiatorTwo = new Gladiator("Example Two");
        Gladiator gladiatorThree = new Gladiator("Example Three");
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        TurnDecider turnDecider = new TurnDecider(gladiators);

        assertEquals("Example One", gladiators.get(0).getName());
        tired.decideIfPlaysAgain(turnDecider);
        assertEquals("Example Two", gladiators.get(0).getName());
    }
    @Test
    public void test04IsWinnerReturnsActiveGameState(){
        Tired tired = new Tired();
        GameState gameState = tired.isWinner("Example");
        assertFalse(gameState.Finalized());
    }
    @Test
    public void test05UpdateTurnReturnsTurnPlusOne(){
        int turn = 1;
        Tired tired = new Tired();
        int newTurn = tired.updateTurn(turn);
        assertEquals(2, newTurn);
    }
    @Test
    public void test06RunEffectIsNotApplied(){
        Tired tired = new Tired();
        Gladiator gladiator = new Gladiator("Example");
        assertEquals(20, gladiator.getEnergy());
        tired.runEffect(new Food(), gladiator);
        assertEquals(20, gladiator.getEnergy());
    }
    @Test
    public void test07ShowStateReturnsCorrectName(){
        Tired tired = new Tired();
        assertEquals("Tired", tired.showState());
    }
    @Test
    public void test08EnergyFromStateReturnsEnergyPointsPlusFivePoints(){
        Tired tired = new Tired();
        assertEquals(5, tired.energyFromState(0));
    }
}

