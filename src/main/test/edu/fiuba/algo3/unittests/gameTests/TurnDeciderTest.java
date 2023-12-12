package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnDeciderTest {
    @Test
    public void test01ReorderArray(){
        ArrayList<Gladiator> array = new ArrayList<>();
        array.add(new Gladiator("ExampleOne"));
        array.add(new Gladiator("ExampleTwo"));
        array.add(new Gladiator("ExampleThree"));
        TurnDecider turnDecider = new TurnDecider(array);
        turnDecider.finishTurn();
        assertEquals("ExampleTwo", array.get(0).getName());
    }
}
