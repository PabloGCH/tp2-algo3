package edu.fiuba.algo3.unittests.gameTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.game.Game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;


public class gameTests {
     @Test void StartGameAndPlayUntilFinish() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       // Arrange
       boolean finish = false;
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(new Gladiator());
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
       effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
       //int middleIndex = (int) (map.stream().count() + 1) / 2;
       //map.add(new FinishLine((Square) map.get(middleIndex)));

       Game game = new Game(gladiators, map);

       // Act

       finish = game.startGame();

       // Assert

       assertFalse(finish);
    }

      @Test void GladiatorIsSuccessfullyAddedToTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       // Arrange
       
       Gladiator gladiator1 = new Gladiator();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

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
       effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
       /*int middleIndex = (int) (map.stream().count() + 1) / 2;
       map.add(new FinishLine((Square) map.get(middleIndex)));*/

       Game game = new Game(gladiators, map); // When adding the gladiator to the game, enter the initial space, giving him 20 energy.

       // Act

       int energyPoints = gladiator1.getEnergy();

       // Assert

       assertTrue(energyPoints == 20);
    }

    @Test void AGladiatorWonTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       // Arrange
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.result();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

       // As this map does not have an equipment upgrade square, it is imposible to win
       ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        squareFactory = new MiddleFactory();
        effectFactory = new FoodFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       Game game = new Game(gladiators, map); // When adding the gladiator to the game, enter the initial space, giving him 20 energy.

       // Act
       game.startGame();
       winner = game.result(0);
       // Assert

       assertTrue(winner);
    }

    @Test void AllTheGladiatorsLostTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       // Arrange
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

       // As this map does not have an equipment upgrade square, it is imposible to win
       ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        squareFactory = new MiddleFactory();
        effectFactory = new FoodFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       Game game = new Game(gladiators, map); // When adding the gladiator to the game, enter the initial space, giving him 20 energy.

       // Act
       game.startGame();
       winner = game.result(0);
       // Assert

       assertFalse(winner);
    }
}
