package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;


public class UseCase12 {
    @Test
    public void tetsGameEnds(){
        // Arrange
        boolean finish = false;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator());

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Square> map = new ArrayList<>();
        map.add(new Initial());
        map.add(new Middle(new Food()));
        map.add(new Middle(new NullEffect()));
        map.add(new Middle(new Bacchanalia()));
        int middleIndex = (int) (map.stream().count() + 1) / 2;
        map.add(new FinishLine(map.get(middleIndex)));

        Game game = new Game(gladiators, map);

        // Act

        finish = game.startGame();

        // Assert

        assertTrue(finish);
    }
}
