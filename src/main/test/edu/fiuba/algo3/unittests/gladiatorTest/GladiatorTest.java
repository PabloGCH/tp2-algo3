package edu.fiuba.algo3.unittests.gladiatorTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Square;

public class GladiatorTest {
    @Test void energyUpdatedCorrectlyAfterEating() {
        Gladiator gladiator = new Gladiator();

        gladiator.eat();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 15);
    }
    @Test void energyUpdatedCorrectlyAfterEatingTwice() {
        Gladiator gladiator = new Gladiator();

        gladiator.eat();
        gladiator.eat();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 30);
    }

    @Test void energyReducedAfterFightWithBeastWithNoEquipment() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 10);
    }

    @Test void upgradeEquipmentOneTime() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 15);
    }

    @Test void upgradeEquipmentTwoTimes() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 20);
    }

    @Test void upgradeEquipmentThreeTimes() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 28);
    }

    @Test void upgradeEquipmentFourTimes() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 30);
    }

    @Test void upgradeEquipmentMoreThanFourTimes() {
        Gladiator gladiator = new Gladiator();
        gladiator.eat();
        gladiator.eat();

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertTrue(energyPoints == 30);
    }

    @Test void ascendToSemiSeniorAfterEightTurns() {
        Gladiator gladiator = new Gladiator();

        for(int i = 0; i < 7; i++) {
            gladiator.turn();
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints);
        gladiator.turn();
        energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }

    @Test void ascendToSeniorAfterEightTurns() {
        Gladiator gladiator = new Gladiator();

        for(int i = 0; i < 11; i++) { 
            gladiator.turn();
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);
        gladiator.turn();
        energyPoints = gladiator.getEnergy();;

        assertEquals(30, energyPoints);
    }

    @Test void SeeTheNewPositionTheGladiatorIsIn() {
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        
        initialSquare.receivePiece(gladiator);
        // TODO fix test;
        // int position = gladiator.turn();
        // Assert

//        assertTrue(position >= 1);
//        assertTrue(position <=6);
    }

    @Test void GladiatorWonTheGame() {
        int winner;
        Gladiator gladiator = new Gladiator();

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.result();
        winner = gladiator.candidateToWin();

        assertTrue(winner == 2);
    }
}
