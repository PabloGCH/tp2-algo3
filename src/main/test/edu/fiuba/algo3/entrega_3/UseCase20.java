package edu.fiuba.algo3.entrega_3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

public class UseCase20 {
    @Test
    public void testPlayerLose() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        // Arrange
        boolean finish = false;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator());

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

        squareFactory = new MiddleFactory();
        effectFactory = new FoodFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));

        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        Game game = new Game(gladiators, map);

        // Act

        finish = game.startGame();

        // Assert

        assertFalse(finish);
    }
}
