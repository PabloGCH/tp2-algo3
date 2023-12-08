package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.ActiveGame;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ActiveGameTests {
    @Test
    public void test01nextTurnChangesGladiatorsPositions(){
        EffectFactory effectFactory = new EffectFactory();
        ActiveGame activeGame = new ActiveGame();
        ArrayList<Gladiator> gladiators = new ArrayList<Gladiator>();
        gladiators.add(new Gladiator("Example"));
        Gladiator currentGladiator = gladiators.get(0);
        ArrayList<Square> path = new ArrayList<>();
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), initialPosition);
        path.add(initialSquare);
        Position newPosition = new Position(0,0,0);
        path.add(new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("Comida"), newPosition));
        initialSquare.affect(currentGladiator);
        assertEquals(currentGladiator.getEnergy(), 20);
        activeGame.nextTurn(gladiators, path, 1, 0);
        assertEquals(currentGladiator.getEnergy(), 35);
    }
}
