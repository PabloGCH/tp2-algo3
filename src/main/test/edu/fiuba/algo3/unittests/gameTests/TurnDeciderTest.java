package edu.fiuba.algo3.unittests.gameTests;

import edu.fiuba.algo3.modelo.game.TurnDecider;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnDeciderTest {
    @Test
    public void test01ReorderArray(){
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
        TurnDecider turnDecider = new TurnDecider(array);
        turnDecider.finishTurn();
        assertEquals(2, array.get(0));
    }
}
