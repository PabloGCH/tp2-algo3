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
        Square firstSquare = new Middle(new NullEffect());
        Square lastSquare = new Middle(new Food());
        firstSquare.setNextPosition(lastSquare);

        //Act
        firstSquare.receivePiece(aGladiator);
        aGladiator.turn();

        //Assert
        Assertions.assertTrue(aGladiator.getEnergy().getPoints() == 0);
    }
}
