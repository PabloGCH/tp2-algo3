package edu.fiuba.algo3.unittests.squareTest;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class squareTest {
    @Test
    public void test01ASquareCanHostAGladiator() {
        Gladiator aGladiator = new Gladiator();
        Square aSquare = new Initial();
        int initialExpectedEnergy = 0;
        int finalExpectedEnergy = 20;
        int initialEnergy;
        int finalEnergy;

        // A gladiator is instanced with 0 energy
        initialEnergy = aGladiator.getEnergy().getPoints();
        assertEquals(initialEnergy,initialExpectedEnergy);

        aSquare.receivePiece(aGladiator);
        finalEnergy = aGladiator.getEnergy().getPoints();
        // if the square hosts a gladiator successfully, the gladiator will be provided with 20 energy points
        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test02AGladiatorAffectedWithFoodEffectGets5EnergyPoints() {
        Gladiator aGladiator = new Gladiator();
        Effect foodEffect = new Food();
        int initialExpectedEnergy = 0;
        int finalExpectedEnergy = 15;
        int initialEnergy;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy().getPoints();
        assertEquals(initialEnergy, initialExpectedEnergy);
        foodEffect.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy().getPoints();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test03AGladiatorWithNoEquipmentLoosesEnergyAfterFight() {
        Gladiator aGladiator = new Gladiator();
        Effect food = new Food();
        Effect fight = new Beast();
        int initialEnergy;
        int finalEnergy;
        int initialExpectedEnergy = 45;
        int finalExpectedEnergy = 25;

        food.affect(aGladiator);
        food.affect(aGladiator);
        food.affect(aGladiator);
        initialEnergy = aGladiator.getEnergy().getPoints();
        assertEquals(initialEnergy, initialExpectedEnergy);

        fight.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy().getPoints();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test04AGladiatorLoosesExpectedEnergyAfterDrinkingWine() {
        Gladiator aGladiator = new Gladiator();
        Effect aBacchanalia = new Bacchanalia();
        int initialEnergy;
        int initialExpectedEnergy = 0;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy().getPoints();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aBacchanalia.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy().getPoints();

        // We can not ensure the exact amount of wine the gladiator will drink. But we can ensure that the gladiator must decrease its energy.
        assertTrue(finalEnergy < initialEnergy);
    }

    @Test
    public void test05ASquareWithNullEffectDoesNotChangeAGladiatorsEnergy() {
        Gladiator aGladiator = new Gladiator();
        Effect aNullEffect = new NullEffect();
        int initialEnergy;
        int finalEnergy;
        int initialExpectedEnergy = 0;
        int finalExpectedEnergy = 0;

        initialEnergy = aGladiator.getEnergy().getPoints();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aNullEffect.affect(aGladiator);

        finalEnergy = aGladiator.getEnergy().getPoints();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test06AGladiatorStepsOnTheFinishLineWithoutKeyAndIsSetOnTheMiddleSquare() {
        Square middleSquare = new Middle(new Food());
        Square finish = new FinishLine(middleSquare);
        Gladiator aGladiator = new Gladiator();
        int expectedInitialEnergy = 0;
        int expectedFinishEnergy = 15;

        assertEquals(expectedInitialEnergy, aGladiator.getEnergy().getPoints());
        finish.receivePiece(aGladiator);

        assertEquals(expectedFinishEnergy, aGladiator.getEnergy().getPoints());
    }

    @Test
    public void test07AGladiatorStepsOnAnInjurySquareBecomesUnableToMove() {
        Square firstNullSquare = new Middle(new NullEffect());
        Square middleSquare = new Middle(new Injury());
        Square secondNullEffectSquare = new Middle(new Food());
        ArrayList<Square> squares = new ArrayList<>();
        squares.add(firstNullSquare);
        squares.add(middleSquare);
        squares.add(secondNullEffectSquare);
        Gladiator aGladiator = new Gladiator();
        int expectedInitialEnergy = 0;
        int expectedEnergyWhenInjured = 0;
        int expectedEnergyWhenEnabledToMove = 15;

        firstNullSquare.receivePiece(aGladiator);
        // TODO fix test;
//        assertEquals(expectedInitialEnergy, aGladiator.getEnergy().getPoints());
//        squares.get(aGladiator.turn()).receiveGladiator(aGladiator);
//        assertEquals(expectedEnergyWhenInjured, aGladiator.getEnergy().getPoints());
//        squares.get(aGladiator.turn()).receiveGladiator(aGladiator);
//        assertEquals(expectedEnergyWhenInjured, aGladiator.getEnergy().getPoints());
//        squares.get(aGladiator.turn()).receiveGladiator(aGladiator);
//
//        assertEquals(expectedEnergyWhenEnabledToMove, aGladiator.getEnergy().getPoints());


    }
}