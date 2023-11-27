package edu.fiuba.algo3.entrega_3;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

public class UseCase20 {
    @Test
    public void testPlayerLose(){
        // Arrange
        boolean finish = false;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator());

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Square> map = new ArrayList<>();
        map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Food()));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        map.add(new FinishLine(map.get(middleIndex)));

        Game game = new Game(gladiators, map);

        // Act

        finish = game.startGame();

        // Assert

        assertFalse(finish);
    }
}
