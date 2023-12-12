package edu.fiuba.algo3.entrega_3;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.position.Position;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

public class UseCase20 {
    @Test
    public void testPlayerLose() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        GameState gameState;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));

        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(3,0,3);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));
        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add(gladiators.get(0).getName());

        Game game = Game.getInstance(gladiatorsNames, map);
        game.startGame();
        gameState = game.playTurn(1);
        while (!gameState.Finalized()){
            gameState = game.playTurn(1);
        }

        Assertions.assertFalse(gameState.result(gladiatorsNames));
        game.restartGame();
    }
}
