package edu.fiuba.algo3.unittests.gladiatorTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;


public class GladiatorTest {
    @Test void energyUpdatedCorrectlyAfterEating() {
        //Arrange
        Gladiator gladiator = new Gladiator();
        //Act
        gladiator.eat();
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 15);
    }
    @Test void energyUpdatedCorrectlyAfterEatingTwice() {
        //Arrange
        Gladiator gladiator = new Gladiator();
        //Act
        gladiator.eat();
        gladiator.eat();
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 30);
    }

    @Test void energyReducedAfterFightWithBeastWithNoEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.fightWithBeast(); // Looses 20 energy if it has no equipment
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 10);
    }

    @Test void upgradeEquipmentOneTime() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.upgrade(); //If it has no equipment, it gets a helment
        gladiator.fightWithBeast(); // Looses 15 energy if it has a helmet
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 15);
    }

    @Test void upgradeEquipmentTwoTimes() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.upgrade(); //If it has no equipment, it gets a helmet
        gladiator.upgrade(); //If it has a helmet, it gets armor
        gladiator.fightWithBeast(); // Looses 10 energy if it has a armor
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 20);
    }

    @Test void upgradeEquipmentThreeTimes() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.upgrade(); //If it has no equipment, it gets a helmet
        gladiator.upgrade(); //If it has a helmet, it gets armor
        gladiator.upgrade(); //If it has armor, it gets sword and shield
        gladiator.fightWithBeast(); // Looses 2 energy if it has sword and shield
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 28);
    }

    @Test void upgradeEquipmentFourTimes() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.upgrade(); //If it has no equipment, it gets a helmet
        gladiator.upgrade(); //If it has a helmet, it gets armor
        gladiator.upgrade(); //If it has armor, it gets sword and shield
        gladiator.upgrade(); //If it has armor, it gets a key
        gladiator.fightWithBeast(); // Does not loose energy if it has a key
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 30);
    }

    @Test void upgradeEquipmentMoreThanFourTimes() {
        //Arrange
        Gladiator gladiator = new Gladiator(); //Starts with 0 energy, and no equipment
        gladiator.eat(); //Adds 15 energy
        gladiator.eat();
        //Act
        gladiator.upgrade(); //If it has no equipment, it gets a helmet
        gladiator.upgrade(); //If it has a helmet, it gets armor
        gladiator.upgrade(); //If it has armor, it gets sword and shield
        gladiator.upgrade(); //If it has armor, it gets a key
        gladiator.upgrade(); //If it has a key it keeps having a key
        gladiator.upgrade(); //If it has a key it keeps having a key
        gladiator.upgrade(); //If it has a key it keeps having a key
        gladiator.fightWithBeast(); // Does not loose energy if it has a key
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertTrue(energyPoints == 30);
    }

    @Test void ascendToSemiSeniorAfterEightTurns() {
        // Arrange
        Gladiator gladiator = new Gladiator();
        // Act
        for(int i = 0; i < 7; i++) { //7 Turns passes
            gladiator.turn();
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints); //Energy does not change when rank is rookie
        gladiator.turn(); // After 8 turn, rank changes to semisenior, each turn passed as semisenior increases energy by 5
        energyPoints = gladiator.getEnergy();
        // Assert
        assertEquals(5, energyPoints);
    }

    @Test void ascendToSeniorAfterEightTurns() {
        // Arrange
        Gladiator gladiator = new Gladiator();
        // Act
        for(int i = 0; i < 11; i++) { 
            gladiator.turn();
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints); //4 turns passed as semisenior so energy should be: 4 * 5 = 20
        gladiator.turn(); // After 12 turn, rank changes to semisenior, each turn passed as semisenior increases energy by 10
        energyPoints = gladiator.getEnergy();;
        // Assert
        assertEquals(30, energyPoints);
    }

    @Test void SeeTheNewPositionTheGladiatorIsIn() {
        // Arrange
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial(); 
        //Act
        
        initialSquare.receivePiece(gladiator); //Should start with 20 energy
        // TODO fix test;
        // int position = gladiator.turn();
        // Assert

//        assertTrue(position >= 1);
//        assertTrue(position <=6);
    }

    @Test void GladiatorWonTheGame() {
        // Arrange
        int winner;
        Gladiator gladiator = new Gladiator();
        
        //Act
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.result();
        winner = gladiator.candidateToWin();
       
        // Assert
        assertTrue(winner == 2);

    }
    
}
