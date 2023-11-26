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
        ArrayList<Square> map = new ArrayList<>();
        map.add(new Initial());
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new NullEffect()));
        var middleOfGameBoard = new Middle(new Food());
        map.add(middleOfGameBoard);
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new NullEffect()));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        var lastSquare = new FinishLine(map.get(middleIndex));
        map.add(lastSquare);
        gladiators.add(aGladiator);
        Game aGame = new Game(gladiators, map);
        lastSquare.receiveGladiator(aGladiator);
        Assertions.assertEquals(aGladiator.getEnergy(), 35);
    }
}
