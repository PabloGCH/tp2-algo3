package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.map.Map;


import java.util.ArrayList;

public class UseCase03 {
    @Test
    public void test03APlayerCantMoveWithoutEnergy() {

        //Arrange
        Gladiator aGladiator = new Gladiator();
        SquareFactory squareFactory = new MiddleFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new FoodFactory();
        Square firstSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),nullEffectFactory.createEffect());
        Square lastSquare = squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect());
        firstSquare.setNextPosition(lastSquare);

        //Act
        firstSquare.receivePiece(aGladiator);
        aGladiator.turn();

        //Assert
        Assertions.assertEquals(aGladiator.getEnergy(), 0);
    }
}
