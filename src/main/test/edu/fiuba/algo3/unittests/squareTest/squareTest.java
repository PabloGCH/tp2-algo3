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
        Square foodSquare = new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), position);
        //Square aSquare = new Initial();
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 35;
        int initialEnergy;
        int finalEnergy;
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        foodSquare.affect(aGladiator);
        //aSquare.receivePiece(aGladiator);
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
        Effect food = new Food();
        Effect fight = new Beast();
        int initialEnergy;
        int finalEnergy;
        int initialExpectedEnergy = 20;
        int finalExpectedEnergy = 0;

        /*food.affect(aGladiator);
        food.affect(aGladiator);
        food.affect(aGladiator);
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);*/
        initialEnergy = aGladiator.getEnergy();
        assertEquals(initialExpectedEnergy, initialEnergy);
        fight.affect(aGladiator);
        finalEnergy = aGladiator.getEnergy();

        assertEquals(finalExpectedEnergy, finalEnergy);
    }

    @Test
    public void test04AGladiatorLoosesExpectedEnergyAfterDrinkingWine() {
        Gladiator aGladiator = new Gladiator("Example");
        Effect aBacchanalia = new Bacchanalia();;
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

        Position middleposition = new Position(3,0,3);
        Square middleOfGameBoard = new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), middleposition);
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

        position = new Position(6,0,6);
        FinishLineEffect finishLineEffect = new FinishLineEffect();
        finishLineEffect.setMiddlePosition(middleposition);
        Square lastSquare = new Square(effectFactory.createSquare("NullEffect"), finishLineEffect, position);
        map.add(lastSquare);
        /*squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        Square lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect());
        map.add(lastSquare);*/

        gladiators.add(aGladiator);
       // Game aGame = Game.getInstance(gladiators, map, new Dice());
        lastSquare.affect(aGladiator);
        //aGame.startGame();

        assertEquals(4, aGladiator.move(map.size(), 1));
    }

    @Test
    public void test07AGladiatorStepsOnAnInjurySquareBecomesUnableToMove() {

        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        Square firstNullSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());*/

        position = new Position(1,0,1);
        Square injurySquare = new Square(effectFactory.createSquare("Lesion"),effectFactory.createSquare("NullEffect"), position);
        map.add(injurySquare);
        /*squareFactory = new MiddleFactory();
        effectFactory = new InjuryFactory();
        Square middleSquare = squareFactory.createSquare(effectFactory.createEffect(),nullEffectFactory.createEffect());*/

        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), position));
        /*effectFactory = new FoodFactory();
        Square secondNullEffectSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());*/

        injurySquare.affect(aGladiator);
        int expectedInitialEnergy = 20;
        int initialPosition = 1;
        int newPosition = aGladiator.move(map.size(), 1);
        assertEquals(initialPosition, newPosition);
        assertEquals(expectedInitialEnergy, aGladiator.getEnergy());
    }
}
