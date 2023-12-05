package edu.fiuba.algo3.unittests.gameTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Dice;
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
       boolean finish = false;
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(new Gladiator("Example 1"));
       gladiators.add(new Gladiator("Example 2"));
         ArrayList<Square> map = new ArrayList<>();
         EffectFactory effectFactory = new EffectFactory();
         Position position = new Position(0,0,0);
         map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

         position = new Position(1,0,1);
         map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

         position = new Position(2,0,2);
         map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));
       /*effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));*/

       //Game game = Game.getInstance(gladiators, map, new Dice());
       //finish = game.startGame();

       //assertFalse(finish);//TODO bucle
    }

      @Test void GladiatorIsSuccessfullyAddedToTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       Gladiator gladiator1 = new Gladiator("Example");
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

          ArrayList<Square> map = new ArrayList<>();
          EffectFactory effectFactory = new EffectFactory();
          Position position = new Position(0,0,0);
          map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

          position = new Position(0,0,0);
          map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

          position = new Position(2,0,2);
          map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));

       Game game = Game.getInstance(gladiators, map, new Dice());
       int energyPoints = gladiator1.getEnergy();

       assertTrue(energyPoints == 20);
    }

    /*TODO bucle
    @Test void AGladiatorWonTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator("Example");
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
    }*/

    @Test void AllTheGladiatorsLostTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
       boolean winner = false;
       Gladiator gladiator1 = new Gladiator("Example");
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));


        position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));
       /*squareFactory = new FinishLineFactory();
       effectFactory = new FinishLineEffectFactory();
       map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));*/
       //Game game = Game.getInstance(gladiators, map, new Dice());
       //game.startGame();
       //winner = game.result(0);

       //assertFalse(winner); //TODO bucle
    }
}
