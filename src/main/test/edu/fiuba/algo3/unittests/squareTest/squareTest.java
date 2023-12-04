package edu.fiuba.algo3.unittests.squareTest;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.factories.*;
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
        Gladiator aGladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position);
        //Square aSquare = new Initial();
        int initialExpectedEnergy = 0;
        int finalExpectedEnergy = 20;
        int initialEnergy;
        int finalEnergy;
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        initialSquare.affect(aGladiator);
        //aSquare.receivePiece(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalEnergy, finalExpectedEnergy);
    }

    @Test
    public void test02AGladiatorAffectedWithFoodEffectGets5EnergyPoints() {
        Gladiator aGladiator = new Gladiator("Example");
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
        Gladiator aGladiator = new Gladiator("Example");
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
        Gladiator aGladiator = new Gladiator("Example");
        Effect aBacchanalia = new Bacchanalia();;
        int initialEnergy;
        int initialExpectedEnergy = 0;
        int finalEnergy;

        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialEnergy, initialExpectedEnergy);
        aBacchanalia.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertTrue(finalEnergy < initialEnergy);
    }

    @Test
    public void test05ASquareWithNullEffectDoesNotChangeAGladiatorsEnergy() {
        Gladiator aGladiator = new Gladiator("Example");
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
        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*ArrayList<Position> map = new ArrayList<>();
        SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();

        Square initialSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(initialSquare);*/

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*squareFactory = new MiddleFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));*/

        position = new Position(3,0,3);
        Square middleOfGameBoard = new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), position);
        map.add(middleOfGameBoard);
        /*effectFactory = new FoodFactory();
        Square middleOfGameBoard = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(middleOfGameBoard);*/
        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        position = new Position(5,0,5);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));*/
        position = new Position(5,0,5);
        Square lastSquare = new Square(effectFactory.createSquare("NullEffect"),new FinishLineEffect(), position);
        map.add(lastSquare);
        /*squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        Square lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(lastSquare);*/

        gladiators.add(aGladiator);
        Game aGame = Game.getInstance(gladiators, map, new Dice());
        lastSquare.affect(aGladiator);
        //aGame.startGame();

        assertEquals(aGladiator.move(map.size(), 1), 4);
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
