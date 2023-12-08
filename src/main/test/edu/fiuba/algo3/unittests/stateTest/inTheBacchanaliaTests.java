package edu.fiuba.algo3.unittests.stateTest;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.InTheBacchanalia;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class inTheBacchanaliaTests {
    @Test
    void test01MoveShouldReturnZeroAndMakeGladiatorDrinkWineWithDiceResult() {
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        int energyExpectedAfterDrinking = 16;
        int number = inTheBacchanalia.move(1);

        assertEquals(0,number);
        assertEquals(energyExpectedAfterDrinking, gladiator.getEnergy());
    }
    @Test
    void test02IfEnergyEqualsZeroUpdateChangesToTiredAndReturnsMoveZeroButGladiatorDoesNotDrinkWine(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        var state = inTheBacchanalia.update(0);
        int number = state.move(1);

        assertEquals(0, number);
        assertEquals(20, gladiator.getEnergy());
    }
    @Test
    public void test03UpdateTurnReturnsTurn(){
        Gladiator gladiator = new Gladiator("Example");
        InTheBacchanalia inTheBacchanalia = new InTheBacchanalia(gladiator);

        int result = inTheBacchanalia.updateTurn(1);

        assertEquals(1, result);
    }
}
