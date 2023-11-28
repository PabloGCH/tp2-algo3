package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UseCase09 {
    @Test
    public void test09AGladiatorReturnsToMiddleSquare() {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator();
        ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
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
        //map.add(lastSquare);
        gladiators.add(aGladiator);
        Game aGame = new Game(gladiators, map);
        lastSquare.receivePiece(aGladiator);
        Assertions.assertEquals(aGladiator.getEnergy(), 35);
    }
}
