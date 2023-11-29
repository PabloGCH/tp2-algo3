package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase10 {
    @Test
    public void test10GladiatorWithKeyReceiveNoDamage(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);

        //Act
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.upgrade();
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();
        //Assert
        assertEquals(20, energyPoints);
    }
}
