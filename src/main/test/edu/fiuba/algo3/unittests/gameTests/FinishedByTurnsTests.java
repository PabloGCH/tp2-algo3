package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.FinishedByTurns;
import edu.fiuba.algo3.modelo.game.FinishedByWinning;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FinishedByTurnsTests {
    @Test
    public void test01NextTurnDoesNotChangeGladiatorsPositions(){
        EffectFactory effectFactory = new EffectFactory();
        FinishedByTurns finishedByTurns = new FinishedByTurns();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        gladiators.add(new Gladiator("Example"));
        Gladiator gladiator = gladiators.get(0);
        ArrayList<Square> path = new ArrayList<>();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), initialPosition);
        path.add(initialSquare);
        Position newPosition = new Position(1,0,1);
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("Comida"), newPosition));
        initialSquare.affect(gladiator);
        assertEquals(gladiator.getEnergy(), 20);
        finishedByTurns.nextTurn(gladiators, path, 1);
        assertEquals(gladiator.getEnergy(), 20);
    }
    @Test
    public void test02NextTurnReturnsFinishedByWinning(){
        EffectFactory effectFactory = new EffectFactory();
        FinishedByTurns finishedByTurns = new FinishedByTurns();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        gladiators.add(new Gladiator("Example"));
        ArrayList<Square> path = new ArrayList<>();
        Position initialPosition = new Position(0,0,0);
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), initialPosition));
        GameState currentGameState = finishedByTurns.nextTurn(gladiators, path, 1);
        assertTrue(currentGameState.Finalized());
        assertFalse(currentGameState.result(new ArrayList<String>()));
    }
    @Test
    public void test03TurnEndedReturnsGladiatorTurnWithoutChange(){
        FinishedByTurns finishedByTurns = new FinishedByTurns();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        int newGladiatorTurn = finishedByTurns.turnEnded(0, gladiators);
        assertEquals(0, newGladiatorTurn);
    }
    @Test
    public void test04EntryOfTheGladiatorToTheFirstSquareDoesNotAffectPositions(){
        EffectFactory effectFactory = new EffectFactory();
        FinishedByTurns finishedByTurns = new FinishedByTurns();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        Gladiator gladiatorOne = new Gladiator("ExampleOne");
        gladiatorOne.positionate(new Position(10,10,10));
        Gladiator gladiatorTwo = new Gladiator("ExampleTwo");
        gladiatorTwo.positionate(new Position(10,10,10));
        Gladiator gladiatorThree = new Gladiator("ExampleThree");
        gladiatorThree.positionate(new Position(10,10,10));
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        ArrayList<Square> path = new ArrayList<>();
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), new Position(0,0,0)));
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), new Position(1,0,1)));

        finishedByTurns.entryOfTheGladiatorToTheFirstSquare(gladiators, path);

        assertEquals(11,gladiatorOne.move(20,1));
        assertEquals(11,gladiatorTwo.move(20,1));
        assertEquals(11,gladiatorThree.move(20,1));
    }
    @Test
    public void test05DefeatReturnsSameState(){
        FinishedByTurns finishedByTurns = new FinishedByTurns();
        ArrayList<String> gladiators = new ArrayList<String>();
        gladiators.add("Example");

        GameState gameState = finishedByTurns.defeat();

        assertFalse(gameState.result(gladiators));
    }
}
