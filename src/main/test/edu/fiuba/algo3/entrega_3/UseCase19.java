package edu.fiuba.algo3.entrega_3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.squares.*;


public class UseCase19 {
    @Test
    public void testPlayerWin() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        // Arrange
        boolean finish = false;
        Gladiator gladiator1 = new Gladiator();
        gladiator1.gameOver();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiator1);
        //Map map = new Map();

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Position> path = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

        path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        squareFactory = new MiddleFactory();
        effectFactory = new UpgradeFactory();
        path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        Game game = new Game(gladiators, path);

        // Act

        finish = game.startGame();

        // Assert

        assertTrue(finish);
    }
}
