package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase06 {
    @Test
    public void testGladiatorGetsShieldSword(){
        Gladiator gladiator = new Gladiator("Example");

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(18, energyPoints);
    }
}
