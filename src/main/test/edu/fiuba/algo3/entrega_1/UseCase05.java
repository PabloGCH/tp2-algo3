package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public class UseCase05 {
    @Test
    public void testGladiatorGetsHelmet(){
        Gladiator gladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        map.get(0).affect(gladiator);
        /*Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);*/

        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();;

        assertEquals(5, energyPoints);
    }
}
