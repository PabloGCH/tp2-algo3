package edu.fiuba.algo3.unittests.gladiatorTest;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;

public class GladiatorTest {
    @Test void energyUpdatedCorrectlyAfterEating() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.eat();
        int energyPoints = gladiator.getEnergy();

        assertEquals(35, energyPoints);
    }
    @Test void energyUpdatedCorrectlyAfterEatingTwice() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.eat();
        gladiator.eat();
        int energyPoints = gladiator.getEnergy();

        assertEquals(50, energyPoints);
    }

    @Test void energyReducedAfterFightWithBeastWithNoEquipment() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(0, energyPoints);
    }

    @Test void upgradeEquipmentOneTime() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(5, energyPoints);
    }

    @Test void upgradeEquipmentTwoTimes() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(10, energyPoints);
    }

    @Test void upgradeEquipmentThreeTimes() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(18, energyPoints);
    }

    @Test void upgradeEquipmentFourTimes() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(20, energyPoints);
    }

    @Test void upgradeEquipmentMoreThanFourTimes() {
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();

        assertEquals(20, energyPoints);
    }

    @Test void ascendToSemiSeniorAfterEightTurns() {
        Gladiator gladiator = new Gladiator("Example");

        for(int i = 0; i < 7; i++) {
            gladiator.move(10,1);
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);
        gladiator.move(10,1);
        energyPoints = gladiator.getEnergy();

        assertEquals(25, energyPoints);
    }

    @Test void ascendToSeniorAfterEightTurns() {
        Gladiator gladiator = new Gladiator("Example");

        for(int i = 0; i < 11; i++) { 
            gladiator.move(20,1);
        }
        int energyPoints = gladiator.getEnergy();
        assertEquals(40, energyPoints);
        gladiator.move(20,1);
        energyPoints = gladiator.getEnergy();

        assertEquals(50, energyPoints);
    }

    @Test void SeeTheNewPositionTheGladiatorIsIn() {
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position);
        
        initialSquare.affect(gladiator);
        int newPosition = gladiator.move(10,1);
        assertEquals(1, newPosition);
    }
}
