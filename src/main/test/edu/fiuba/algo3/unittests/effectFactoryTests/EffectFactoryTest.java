package edu.fiuba.algo3.unittests.effectFactoryTests;

import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EffectFactoryTest {

    @Test
    public void test01FoodEffectCreation() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Effect foodEffect = effectFactory.createEffect("Comida");
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 35;
        int initialEnergy;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        foodEffect.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }
    @Test
    public void test02WineEffectCreation() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Effect aBacchanalia = effectFactory.createEffect("Bacanal");
        int initialEnergy;
        int initialExpectedEnergy = 20;
        int finalEnergy;
        int energyLostInBacchanaliaWithDiceResultOne = 1 * 4;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aBacchanalia.affect(aGladiator);
        aGladiator.move(5,1);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(initialEnergy - energyLostInBacchanaliaWithDiceResultOne, finalEnergy);
    }

    @Test
    public void test03NullEffectCreation() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Effect aNullEffect = effectFactory.createEffect("Example");
        int initialEnergy;
        int finalEnergy;
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 20;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        aNullEffect.affect(aGladiator);

        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }
    @Test
    public void test04InjuryEffectCreation() {

        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        effectFactory = new EffectFactory();
        Effect injuryEffect = effectFactory.createEffect("Lesion");
        position = new Position(1,0,1);
        Square injurySquare = new Square(injuryEffect,effectFactory.createEffect("NullEffect"), position);
        map.add(injurySquare);

        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        injurySquare.affect(aGladiator);
        int expectedInitialEnergy = 20;
        int initialPosition = 1;
        int newPosition = aGladiator.move(map.size(), 1);
        assertEquals(initialPosition, newPosition);
        assertEquals(expectedInitialEnergy, aGladiator.getEnergy());
    }
    @Test
    public void test05BeastEffectCreation() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Effect beastEffect = effectFactory.createEffect("Fiera");
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 0;
        int initialEnergy;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        beastEffect.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }
    @Test
    public void test06UpgradeEffectCreation() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Effect upgradeEffect = effectFactory.createEffect("Equipamiento");
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 5;
        int initialEnergy;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        upgradeEffect.affect(aGladiator);
        aGladiator.fightWithBeast();
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }
}
