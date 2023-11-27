package edu.fiuba.algo3.entrega_3;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.squares.*;


public class UseCase19 {
    @Test
    public void testPlayerWin(){
        // Arrange
        boolean finish = false;
        Gladiator gladiator1 = new Gladiator();
        gladiator1.gameOver();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiator1);
        //Map map = new Map();

        // As this map does not have an equipment upgrade square, it is imposible to win
        ArrayList<Square> path = new ArrayList<>();
        path.add(new Initial());
        path.add(new Middle(new Upgrade()));
        path.add(new Middle(new Upgrade()));
        path.add(new Middle(new Upgrade()));
        int middleIndex = (int) (path.stream().count() + 1) / 2;
        path.add(new FinishLine(path.get(middleIndex)));

        Game game = new Game(gladiators, path);

        // Act

        finish = game.startGame();

        // Assert

        assertTrue(finish);
    }
}
