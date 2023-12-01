package edu.fiuba.algo3.gameTests;

import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import java.util.ArrayList;

public class gameTests {
     @Test void StartGameAndPlayUntilFinish() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       boolean finish = false;
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(new Gladiator());
       gladiators.add(new Gladiator());

       ArrayList<Position> map = new ArrayList<>();
       SquareFactory squareFactory = new InitialFactory();
       EffectFactory nullEffectFactory = new NullEffectFactory();
       EffectFactory effectFactory = new InitialEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       squareFactory = new MiddleFactory();
       effectFactory = new FoodFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

       Game game = new Game(gladiators, map);
       finish = game.startGame();

       assertFalse(finish);
    }

      @Test void GladiatorIsSuccessfullyAddedToTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       Gladiator gladiator1 = new Gladiator();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

       ArrayList<Position> map = new ArrayList<>();
       SquareFactory squareFactory = new InitialFactory();
       EffectFactory nullEffectFactory = new NullEffectFactory();
       EffectFactory effectFactory = new InitialEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       squareFactory = new MiddleFactory();
       effectFactory = new FoodFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

       effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));

       Game game = new Game(gladiators, map);
       int energyPoints = gladiator1.getEnergy();

       assertTrue(energyPoints == 20);
    }

    @Test void AGladiatorWonTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.upgrade();
       gladiator1.result();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

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

       Game game = new Game(gladiators, map);
       game.startGame();
       winner = game.result(0);

       assertTrue(winner);
    }

    @Test void AllTheGladiatorsLostTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

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

       Game game = new Game(gladiators, map);
       game.startGame();
       winner = game.result(0);

       assertFalse(winner);
    }
}
