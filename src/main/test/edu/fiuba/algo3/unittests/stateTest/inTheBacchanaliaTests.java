package edu.fiuba.algo3.unittests.stateTest;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.*;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Food;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class inTheBacchanaliaTests {
    @Test
    void test01MoveShouldReturnZeroAndMakeGladiatorDrinkWineWithDiceResult() {
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        int energyExpectedAfterDrinking = 16;
        int number = inTheBacchanalia.move(1);

        assertEquals(0,number);
        assertEquals(energyExpectedAfterDrinking, gladiator.getEnergy());
    }
    @Test
    void test02IfEnergyBelowZeroUpdateChangesToTiredStateAndReturnsMoveReturnsZeroButGladiatorDoesNotDrinkWine(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        var state = inTheBacchanalia.update(0);
        int number = state.move(1);

        assertEquals(0, number);
        assertEquals(20, gladiator.getEnergy());
    }
    @Test
    public void test03UpdateTurnReturnsTurn(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        int result = inTheBacchanalia.updateTurn(1);

        assertEquals(1, result);
    }

    @Test
    public void test04RunEffectTurnsGladiatorIntoActiveState(){
        Gladiator gladiator = new Gladiator("Example");
        gladiator.positionate(new Position(0,0,0));
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        inTheBacchanalia.runEffect(new Bacchanalia(), gladiator);

        assertEquals(1, gladiator.move(5,1));
    }
    @Test
    public void test05DecideIfPlaysAgainSetSecondGladiatorInInitialIndex(){
        Gladiator gladiatorOne = new Gladiator("Example One");
        Gladiator gladiatorTwo = new Gladiator("Example Two");
        Gladiator gladiatorThree = new Gladiator("Example Three");
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiatorOne);
        TurnDecider turnDecider = new TurnDecider(gladiators);

        assertEquals("Example One", gladiators.get(0).getName());
        inTheBacchanalia.decideIfPlaysAgain(turnDecider);
        assertEquals("Example One", gladiators.get(0).getName());
    }
    @Test
    public void test06IsWinnerReturnsActiveGameState(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);
        GameState gameState = inTheBacchanalia.isWinner();
        assertFalse(gameState.Finalized());
    }
    @Test
    public void test07RunEffectIsNotApplied(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);
        assertEquals(20, gladiator.getEnergy());
        inTheBacchanalia.runEffect(new Food(), gladiator);
        assertEquals(20, gladiator.getEnergy());
    }
    @Test
    public void test08GetIntoBacchanliaSentGladiatorIntoThisStateAgain(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);
        State state = inTheBacchanalia.getIntoBacchanalia(gladiator);

        int energyExpectedAfterDrinking = 16;
        int number = state.move(1);

        assertEquals(0,number);
        assertEquals(energyExpectedAfterDrinking, gladiator.getEnergy());
    }
    @Test
    void test09IfEnergyPositiveUpdateChangesToActiveStateAndReturnsMoveReturnsDiceResult(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        var state = inTheBacchanalia.update(10);
        int number = state.move(1);

        assertEquals(1, number);
    }
}
