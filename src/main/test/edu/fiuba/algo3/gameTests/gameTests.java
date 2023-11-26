package edu.fiuba.algo3.gameTests;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.Game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;


public class gameTests {
     @Test void StartGameAndPlayUntilFinish() {
       // Arrange
       boolean finish = false;
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(new Gladiator());
       gladiators.add(new Gladiator());

       // As this map does not have an equipment upgrade square, it is imposible to win
       ArrayList<Square> map = new ArrayList<>();
       map.add(new Initial());
       map.add(new Middle(new Food()));
       int middleIndex = (int) (map.stream().count() + 1) / 2;
       map.add(new FinishLine(map.get(middleIndex)));

       Game game = new Game(gladiators, map);

       // Act

       finish = game.startGame();

       // Assert

       assertTrue(finish);
    }

      @Test void GladiatorIsSuccessfullyAddedToTheGame() {
       // Arrange
       
       Gladiator gladiator1 = new Gladiator();
       ArrayList<Gladiator> gladiators = new ArrayList<>();
       gladiators.add(gladiator1);

       // As this map does not have an equipment upgrade square, it is imposible to win
       ArrayList<Square> map = new ArrayList<>();
       map.add(new Initial());
       map.add(new Middle(new Food()));
       int middleIndex = (int) (map.stream().count() + 1) / 2;
       map.add(new FinishLine(map.get(middleIndex)));

       Game game = new Game(gladiators, map); // When adding the gladiator to the game, enter the initial space, giving him 20 energy.

       // Act

       int energyPoints = gladiator1.getEnergy();

       // Assert

       assertTrue(energyPoints == 20);
    }
}
