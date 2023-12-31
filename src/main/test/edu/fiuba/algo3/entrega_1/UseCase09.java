package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class UseCase09 {
    @Test
    public void test09AGladiatorReturnsToMiddleSquare(){
        Gladiator aGladiator = new Gladiator("Example");

        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        Position middleposition = new Position(3,0,3);
        Square middleOfGameBoard = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position);
        map.add(middleOfGameBoard);

        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(5,0,5);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(6,0,6);
        FinishLineEffect finishLineEffect = new FinishLineEffect();
        finishLineEffect.setMiddlePosition(middleposition);
        Square lastSquare = new Square(effectFactory.createEffect("NullEffect"), finishLineEffect, position);
        map.add(lastSquare);

        lastSquare.affect(aGladiator);

        Assertions.assertEquals(3, aGladiator.move(map.size(), 0));
    }
}
