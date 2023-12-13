package edu.fiuba.algo3.unittests.squareTest;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class squareTest {
    @Test
    public void test01ASquareCanHostAGladiator() {
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square foodSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position);
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 35;
        int initialEnergy;
        int finalEnergy;
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        foodSquare.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }

    @Test
    public void test02AGladiatorAffectedWithFoodEffectGets15EnergyPoints() {
        Gladiator aGladiator = new Gladiator("Example");
        Effect foodEffect = new Food();
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
    public void test03AGladiatorWithNoEquipmentLoosesEnergyAfterFight() {
        Gladiator aGladiator = new Gladiator("Example");
        Effect fight = new Beast();
        int initialEnergy;
        int finalEnergy;
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 0;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        fight.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }

    @Test
    public void test04AGladiatorLoosesExpectedEnergyAfterDrinkingWine() {
        Gladiator aGladiator = new Gladiator("Example");
        Effect aBacchanalia = new Bacchanalia();
        int initialEnergy;
        int initialExpectedEnergy = 20;
        int finalEnergy;
        int energyLostInBacchanaliaWithDiceResultOne = 4;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aBacchanalia.affect(aGladiator);
        aGladiator.move(5,1);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(initialEnergy - energyLostInBacchanaliaWithDiceResultOne, finalEnergy);
    }

    @Test
    public void test05ASquareWithNullEffectDoesNotChangeAGladiatorsEnergy() {
        Gladiator aGladiator = new Gladiator("Example");
        Effect aNullEffect = new NullEffect();
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
    public void test06AGladiatorStepsOnTheFinishLineWithoutKeyAndIsSetOnTheMiddleSquare() {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        Position middleposition = new Position(3,0,3);
        Square middleOfGameBoard = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), middleposition);
        map.add(middleOfGameBoard);
        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(5,0,5);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(6,0,6);
        FinishLineEffect finishLineEffect = new FinishLineEffect();
        finishLineEffect.setMiddlePosition(middleposition);
        Square lastSquare = new Square(effectFactory.createEffect("NullEffect"), finishLineEffect, position);
        map.add(lastSquare);


        gladiators.add(aGladiator);

        lastSquare.affect(aGladiator);

        assertEquals(4, aGladiator.move(map.size(), 1));
    }

    @Test
    public void test07AGladiatorStepsOnAnInjurySquareBecomesUnableToMove() {

        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        Square injurySquare = new Square(effectFactory.createEffect("Lesion"),effectFactory.createEffect("NullEffect"), position);
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
    public void test08FoodGetNameReturnsCorrectName(){
        Food food = new Food();
        assertEquals("food", food.getName());
    }
    @Test
    public void test09NullEffectGetNameReturnsCorrectName(){
        NullEffect nullEffect = new NullEffect();
        assertEquals("", nullEffect.getName());
    }
    @Test
    public void test10UpgradeGetNameReturnsCorrectName(){
        Upgrade upgrade = new Upgrade();
        assertEquals("upgrade", upgrade.getName());
    }
    @Test
    public void test11InjuryGetNameReturnsCorrectName(){
        Injury injury = new Injury();
        assertEquals("injury", injury.getName());
    }
    @Test
    public void test12FinishLineEffectGetNameReturnsCorrectName(){
        FinishLineEffect finishLineEffect = new FinishLineEffect();
        assertEquals("finishline", finishLineEffect.getName());
    }
    @Test
    public void test13BeastGetNameReturnsCorrectName(){
        Beast beast = new Beast();
        assertEquals("beast", beast.getName());
    }
    @Test
    public void test14BacchanaliaGetNameReturnsCorrectName(){
        Bacchanalia bacchanalia = new Bacchanalia();
        assertEquals("bacchanalia", bacchanalia.getName());
    }
    @Test
    public void test15getEffectNamesReturnCorrectsNames(){
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square square = new Square(effectFactory.createEffect("Fiera"), effectFactory.createEffect("Comida"),position);
        ArrayList<String> effectsNames = square.getEffectNames();
        assertEquals("beast", effectsNames.get(0));
        assertEquals("food", effectsNames.get(1));
    }
}
