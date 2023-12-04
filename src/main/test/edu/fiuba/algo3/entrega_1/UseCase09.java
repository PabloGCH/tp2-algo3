package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.factories.*;
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
        Gladiator aGladiator = new Gladiator("Example");
        //ArrayList<Position> map = new ArrayList<>();
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

        Square initialSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(initialSquare);*/

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*
        squareFactory = new MiddleFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));*/

        Position middleposition = new Position(3,0,3);
        Square middleOfGameBoard = new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), position);
        map.add(middleOfGameBoard);
        /*effectFactory = new FoodFactory();
        var middleOfGameBoard = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(middleOfGameBoard);*/

        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        position = new Position(5,0,5);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));

        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));*/

        position = new Position(6,0,6);
        FinishLineEffect finishLineEffect = new FinishLineEffect();
        finishLineEffect.setMiddlePosition(middleposition);
        Square lastSquare = new Square(effectFactory.createSquare("NullEffect"), finishLineEffect, position);
        map.add(lastSquare);

        /*squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        var lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(lastSquare);*/

        gladiators.add(aGladiator);
        //Game aGame = Game.getInstance(gladiators, map, new Dice());
        lastSquare.affect(aGladiator);
        //aGame.startGame();

        Assertions.assertEquals(4, aGladiator.move(map.size(), 1));
    }
}
