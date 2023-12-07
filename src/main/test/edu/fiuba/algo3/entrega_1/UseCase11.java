package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase11 {
    @Test
    public void testGladiatorWithKeyUpgradeHasNoEffect() {
        Gladiator gladiator = new Gladiator("Example");
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0, 0, 0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"), effectFactory.createEffect("NullEffect"), position);
        initialSquare.affect(gladiator);

        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(20, energyPoints);
        gladiator.upgrade();
        energyPoints = gladiator.getEnergy();;
        assertEquals(20, energyPoints);
    }
}
