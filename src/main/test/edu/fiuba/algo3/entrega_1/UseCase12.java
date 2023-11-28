package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Config;
import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;


public class UseCase12 {
    @Test
    public void tetsGameEnds() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        // Arrange
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        boolean finish = false;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator());

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        //map.add(new Initial());
        squareFactory = new MiddleFactory();
        effectFactory = new FoodFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        //map.add(new Middle(new Food()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        effectFactory = new BacchanaliaFactory();
        map.add(squareFactory.createSquare(effectFactory.createEffect(),nullEffectFactory.createEffect()));
        //map.add(new Middle(new Bacchanalia(dice)));
        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        //int middleIndex = (int) (map.stream().count() + 1) / 2;
        //map.add(new FinishLine((Square) map.get(middleIndex)));

        Game game = new Game(gladiators, map);

        // Act

        finish = game.startGame(Config.MAX_TURNS_IN_A_GAME.getValue());

        // Assert

        assertFalse(finish);
    }
}
