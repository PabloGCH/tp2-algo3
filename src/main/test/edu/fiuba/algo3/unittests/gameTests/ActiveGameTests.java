package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActiveGameTests {
    @Test
    public void test01NextTurnChangesGladiatorsPositions(){
        EffectFactory effectFactory = new EffectFactory();
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
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
        activeGame.nextTurn(gladiators, path, 1);
        assertEquals(gladiator.getEnergy(), 35);
    }
    @Test//Preguntar si usar otro metodo para comprobar es correcto
    public void test02NextTurnReturnsActiveGameIfGladiatorIsNotWinner(){
        EffectFactory effectFactory = new EffectFactory();
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        ArrayList<Square> path = new ArrayList<>();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), initialPosition);
        path.add(initialSquare);
        Position newPosition = new Position(1,0,1);
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), newPosition));
        GameState currentGameState = activeGame.nextTurn(gladiators, path, 1);
        assertFalse(currentGameState.Finalized());
    }
    @Test
    public void test03FinalizedReturnsFalse(){
        ActiveGame activeGame = new ActiveGame();
        assertFalse(activeGame.Finalized());
    }
    @Test//Comentar mariano gladiadores
    public void test04ResultReturnsFalse(){
        ActiveGame activeGame = new ActiveGame();
        ArrayList<String> gladiatorsNames = new ArrayList<>();
        assertFalse(activeGame.result(gladiatorsNames));
    }
    @Test
    public void test05TurnEndedReturnsGladiatorTurnPlusOneIfNotInBacchanalia(){
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        int newGladiatorTurn = activeGame.turnEnded(0, gladiators);
        assertEquals(1, newGladiatorTurn);
    }
    @Test
    public void test05TurnEndedReturnsGladiatorTurnWithoutChangeIfInBacchanalia(){
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator gladiator = new Gladiator("Example");
        Bacchanalia bacchanalia = new Bacchanalia();
        bacchanalia.affect(gladiator);
        gladiators.add(gladiator);
        int newGladiatorTurn = activeGame.turnEnded(0, gladiators);
        assertEquals(0, newGladiatorTurn);
    }
    @Test
    public void test06GladiatorsAreSetIntoFirstPathSquare(){
        EffectFactory effectFactory = new EffectFactory();
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator gladiatorOne = new Gladiator("ExampleOne");
        Gladiator gladiatorTwo = new Gladiator("ExampleTwo");
        Gladiator gladiatorThree = new Gladiator("ExampleThree");
        gladiators.add(gladiatorOne);
        gladiators.add(gladiatorTwo);
        gladiators.add(gladiatorThree);
        ArrayList<Square> path = new ArrayList<>();
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("Comida"), new Position(0,0,0)));
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), new Position(1,0,1)));
        activeGame.entryOfTheGladiatorToTheFirstSquare(gladiators, path);
        assertEquals(35,gladiatorOne.getEnergy());
        assertEquals(35,gladiatorTwo.getEnergy());
        assertEquals(35,gladiatorThree.getEnergy());
    }

    @Test
    public void test07DefaultReturnsTheFinishedByTurnsClass(){
        ActiveGame activeGame = new ActiveGame();

        var finishedByTurns = activeGame.defeat();

        assertTrue(finishedByTurns.Finalized());
    }
    @Test
    public void test08DefeatReturnsSameState(){
        ActiveGame activeGame = new ActiveGame();
        ArrayList<String> gladiators = new ArrayList<>();
        gladiators.add("Example");

        GameState gameState = activeGame.defeat();

        assertFalse(gameState.result(gladiators));
    }
}
