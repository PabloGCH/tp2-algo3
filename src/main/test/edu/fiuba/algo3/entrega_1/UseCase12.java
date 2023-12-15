package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UseCase12 {
    @Test
    public void testGameEnds(){
        GameState gameState;
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));


        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add("Example");

        Game game = Game.getInstance(gladiatorsNames, map);
        game.startGame();
        gameState = game.playTurn(1);
        while (!gameState.Finalized()){
            gameState = game.playTurn(1);
        }

        assertFalse(gameState.result(gladiatorsNames));
        game.restartGame();
    }
}
