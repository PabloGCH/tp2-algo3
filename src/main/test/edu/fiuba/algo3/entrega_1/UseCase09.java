package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Config;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UseCase09 {
    @Test
    public void test09AGladiatorReturnsToMiddleSquare() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator();
        ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        Square initialSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(initialSquare);
        //map.add(new Initial());
        squareFactory = new MiddleFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        effectFactory = new FoodFactory();
        var middleOfGameBoard = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        //var middleOfGameBoard = new Middle(new Food());
        map.add(middleOfGameBoard);
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        //int middleIndex = (int) (map.stream().count() + 1) / 2;
        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        var lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        //var lastSquare = new FinishLine((Square) map.get(middleIndex));
        map.add(lastSquare);

        gladiators.add(aGladiator);
        Game aGame = new Game(gladiators, map);
        initialSquare.receivePiece(aGladiator);//player starts at initial square and receive 20 energy points
        initialSquare.removePiece(aGladiator);
        lastSquare.receivePiece(aGladiator);// Player reach the finish line: if they have a key, gladiator´s worthy value equals ABLE_TO_WIN (2)
        aGame.startGame(1);
        /*As the player reached the finishline without a key, they are sent to the middle and gladiator´s worthy is UNABLE_TO_WIN (0),
         only when is standing on the finish line without the key worthy equals UNABLE_TO_WIN_ON_FINISH_LINE*/
        Assertions.assertEquals(Config.UNABLE_TO_WIN.getValue(), aGladiator.candidateToWin());
        Assertions.assertEquals(35, aGladiator.getEnergy());//
    }
}
