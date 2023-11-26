package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase02 {
    @Test
    public void test02ANewPlayersGladiatorStartsAtTheInitialSquare() {
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator();
        ArrayList<Square> map = new ArrayList<>();
        map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Bacchanalia(dice)));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        map.add(new FinishLine(map.get(middleIndex)));
        gladiators.add(aGladiator);
        Game aGame = new Game(gladiators, map);
        Assertions.assertTrue(aGladiator.getEnergy().getPoints() == 20);
    }
}
