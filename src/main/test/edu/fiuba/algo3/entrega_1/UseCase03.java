package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UseCase03 {
    @Test
    public void test03APlayerCantMoveWithoutEnergy() {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        map.get(0).affect(aGladiator);
        aGladiator.fightWithBeast();
        int initialPositionInPath = 0;
        int newPositionInPath = aGladiator.move(map.size(), 1);

        Assertions.assertEquals(initialPositionInPath, newPositionInPath);
        Assertions.assertEquals(aGladiator.getEnergy(), 0);
    }
}
