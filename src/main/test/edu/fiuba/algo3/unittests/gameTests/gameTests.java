package edu.fiuba.algo3.unittests.gameTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import java.util.ArrayList;

public class gameTests {
         @Test void test01StartGameAndPlayUntilFinish() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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

       Game game = Game.getInstance(gladiators, map, new Dice());
       finish = game.startGame();

       assertFalse(finish);
    }

      @Test void test02GladiatorIsSuccessfullyAddedToTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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

    @Test void test03AllTheGladiatorsLostTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
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
       Game game = Game.getInstance(gladiators, map, new Dice());
       boolean finish = game.startGame();

       assertFalse(finish);
    }
    @Test
    public void test04GetPathReturnsTheRightPath(){
        ArrayList<Square> map = new ArrayList<>();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position positionOne = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), positionOne));
        Position positionTwo = new Position(1,1,0);
        Game game = Game.getInstance(gladiators, map, new Dice());
        ArrayList<Square> mapReceived = game.getPath();
        assertTrue(positionOne.comparePosition(mapReceived.get(0).getPosition()));
    }
}
