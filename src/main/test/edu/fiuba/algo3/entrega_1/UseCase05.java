package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public class UseCase05 {
    @Test
    public void testGladiatorGetsHelmet(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(5, energyPoints);
    }
}
