package edu.fiuba.algo3.entrega_1;
import static org.junit.jupiter.api.Assertions.*;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {

    @Test
    public void testGladiatorStartsWithCorrectEnergy() {
        Gladiator gladiator = new Gladiator(); 
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);
        int energyPoints = gladiator.getEnergy();;
        assertEquals(20, energyPoints);
    }
    @Test
    public void testGladiatorStartsWithNullEquipment() {
        Gladiator gladiator = new Gladiator();
        Square initialSquare = new Initial();
        initialSquare.receivePiece(gladiator);
        gladiator.fightWithBeast();
        int energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints);
    }
}
