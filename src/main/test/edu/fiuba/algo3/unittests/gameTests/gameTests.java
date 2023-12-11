package edu.fiuba.algo3.unittests.gameTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.GameState;
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
    @Test
    void test01StartGameAndPlayUntilFinish() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        GameState gameState;
        Dice dice = new Dice();
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

       ArrayList<String> gladiatorsNames = new ArrayList<>();
       gladiatorsNames.add(gladiators.get(0).getName());
       gladiatorsNames.add(gladiators.get(1).getName());

        Game game = Game.getInstance();
        if(game != null){
            game.restartGame();
        }

        game = Game.getInstance(gladiatorsNames, map, dice);
       game.startGame();
       gameState = game.playTurn(dice.throwDice());
       while (!gameState.Finalized()){
           gameState = game.playTurn(dice.throwDice());
       }

       assertFalse(gameState.result(gladiators));
    }

    @Test
    void test02GladiatorIsSuccessfullyAddedToTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Dice dice = new Dice();
        GameState gameState;
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

       ArrayList<String> gladiatorsNames = new ArrayList<>();
       gladiatorsNames.add(gladiators.get(0).getName());

       Game game = Game.getInstance(gladiatorsNames, map, dice);
        game.startGame();

        assertEquals(20, gladiator1.getEnergy());
    }

    @Test
    void test03AllTheGladiatorsLostTheGame() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Dice dice = new Dice();
        GameState gameState;
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

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add(gladiators.get(0).getName());

        Game game = Game.getInstance(gladiatorsNames, map, dice);
        game.startGame();
        gameState = game.playTurn(dice.throwDice());
        while (!gameState.Finalized()){
            gameState = game.playTurn(dice.throwDice());
        }

        assertFalse(gameState.result(gladiators));
    }
    @Test
    public void test04GetPathReturnsTheRightPath(){
        Dice dice = new Dice();
        GameState gameState;
        ArrayList<Square> map = new ArrayList<>();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position positionOne = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), positionOne));
        Position positionTwo = new Position(1,1,0);

        ArrayList<String> gladiatorsNames = new ArrayList<>();

        Game game = Game.getInstance(gladiatorsNames, map, dice);
        ArrayList<Square> mapReceived = game.getPath();
        assertTrue(positionOne.comparePosition(mapReceived.get(0).getPosition()));
    }
}
