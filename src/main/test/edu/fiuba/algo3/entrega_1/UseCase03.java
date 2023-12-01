package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UseCase03 {
    @Test
    public void test03APlayerCantMoveWithoutEnergy() {
        Gladiator aGladiator = new Gladiator();
        SquareFactory squareFactory = new MiddleFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new FoodFactory();
        Square firstSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),nullEffectFactory.createEffect());
        Square lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());
        firstSquare.setNextPosition(lastSquare);

        firstSquare.receivePiece(aGladiator);
        aGladiator.turn();

        Assertions.assertEquals(aGladiator.getEnergy(), 0);
    }
}
