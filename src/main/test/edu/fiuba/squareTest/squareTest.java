package edu.fiuba.squareTest;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

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

        aSquare.receiveGladiator(aGladiator);
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

        // We can not ensure the exact amount of wine the gladiator will drink. But we can ensure that the gladiator must increase its energy.
        assertTrue(finalEnergy > initialEnergy);
    }
}
