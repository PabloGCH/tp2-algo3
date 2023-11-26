package edu.fiuba.algo3.unittests.squareTest;

import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
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
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy,initialExpectedEnergy);

        aSquare.receiveGladiator(aGladiator);
        finalEnergy = aGladiator.getEnergy();
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

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        foodEffect.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

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
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);

        fight.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test04AGladiatorLoosesExpectedEnergyAfterDrinkingWine() {
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        Gladiator aGladiator = new Gladiator();
        Effect aBacchanalia = new Bacchanalia(dice);
        int initialEnergy;
        int initialExpectedEnergy = 0;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aBacchanalia.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        // We can not ensure the exact amount of wine the gladiator will drink. But we can ensure that the gladiator must increase its energy.
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

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aNullEffect.affect(aGladiator);

        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test06() {

    }
}
