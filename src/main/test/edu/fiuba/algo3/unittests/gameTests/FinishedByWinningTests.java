package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.FinishedByWinning;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FinishedByWinningTests {
    @Test
    public void test01NextTurnDoesNotChangeGladiatorsPositions(){
        EffectFactory effectFactory = new EffectFactory();
        FinishedByWinning finishedGame = new FinishedByWinning();
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
        finishedGame.nextTurn(gladiators, path, 1, 0);
        assertEquals(gladiator.getEnergy(), 20);
    }
    @Test
    public void test02NextTurnReturnsFinishedByWinning(){
        EffectFactory effectFactory = new EffectFactory();
        FinishedByWinning finishedGame = new FinishedByWinning();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        gladiators.add(new Gladiator("Example"));
        ArrayList<Square> path = new ArrayList<>();
        Position initialPosition = new Position(0,0,0);
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), initialPosition));
        GameState currentGameState = finishedGame.nextTurn(gladiators, path, 1, 0);
        assertTrue(currentGameState.Finalized());
    }
    @Test
    public void test03FinalizedReturnsTrue(){
        FinishedByWinning finishedGame = new FinishedByWinning();
        assertTrue(finishedGame.Finalized());
    }
    @Test//Comentar mariano gladiadores
    public void test04ResultReturnsTrue(){
        FinishedByWinning finishedGame = new FinishedByWinning();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        gladiators.add(new Gladiator("Example"));
        assertTrue(finishedGame.result(gladiators));
    }
    @Test
    public void test05TurnEndedReturnsGladiatorTurnWithoutChange(){
        FinishedByWinning finishedGame = new FinishedByWinning();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        int newGladiatorTurn = finishedGame.turnEnded(0, gladiators);
        assertEquals(0, newGladiatorTurn);
    }
}
