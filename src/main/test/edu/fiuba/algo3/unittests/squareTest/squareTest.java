package edu.fiuba.algo3.unittests.squareTest;

import edu.fiuba.algo3.modelo.Config;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
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
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);

        aSquare.receivePiece(aGladiator);
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
        Gladiator aGladiator = new Gladiator();
        Effect aBacchanalia = new Bacchanalia();
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
    public void test06AGladiatorStepsOnTheFinishLineWithoutKeyAndIsSetOnTheMiddleSquare() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator();
        ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        Square initialSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(initialSquare);
        //map.add(new Initial());
        squareFactory = new MiddleFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        effectFactory = new FoodFactory();
        var middleOfGameBoard = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        //var middleOfGameBoard = new Middle(new Food());
        map.add(middleOfGameBoard);
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        //map.add(new Middle(new NullEffect()));
        //int middleIndex = (int) (map.stream().count() + 1) / 2;
        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        var lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        //var lastSquare = new FinishLine((Square) map.get(middleIndex));
        map.add(lastSquare);

        gladiators.add(aGladiator);
        Game aGame = new Game(gladiators, map);
        initialSquare.receivePiece(aGladiator);//player starts at initial square and receive 20 energy points
        lastSquare.receivePiece(aGladiator);// Player reach the finish line: if they have a key, gladiator´s worthy value equals ABLE_TO_WIN (2)
        aGame.startGame();
       /*As the player reached the finishline without a key, they are sent to the middle and gladiator´s worthy is UNABLE_TO_WIN (0),
         only when is standing on the finish line without the key worthy equals UNABLE_TO_WIN_ON_FINISH_LINE*/
        Assertions.assertEquals(Config.UNABLE_TO_WIN.getValue(), aGladiator.candidateToWin());
        Assertions.assertEquals(35, aGladiator.getEnergy());//
    }
    /*
    @Test
    public void test07AGladiatorStepsOnAnInjurySquareBecomesUnableToMove() {
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        Square firstNullSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());
        //Square firstNullSquare = new Middle(new NullEffect());
        squareFactory = new MiddleFactory();
        effectFactory = new InjuryFactory();
        Square middleSquare = squareFactory.createSquare(effectFactory.createEffect(),nullEffectFactory.createEffect());
        //Square middleSquare = new Middle(new Injury());
        effectFactory = new FoodFactory();
        Square secondNullEffectSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());
        //Square secondNullEffectSquare = new Middle(new Food());
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

    }*/
}
