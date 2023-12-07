package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {

    @Test
    public void testGladiatorStartsWithCorrectEnergy() {
        EffectFactory effectFactory = new EffectFactory();
        Gladiator gladiator = new Gladiator("Example");
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), initialPosition);
        initialSquare.affect(gladiator);
        int energyPoints = gladiator.getEnergy();;
        assertEquals(20, energyPoints);
    }
    @Test
    public void testGladiatorStartsWithNullEquipment() {
        EffectFactory effectFactory = new EffectFactory();
        Gladiator gladiator = new Gladiator("Example");
        Position initialPosition = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), initialPosition);
        initialSquare.affect(gladiator);
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints);
    }
}
