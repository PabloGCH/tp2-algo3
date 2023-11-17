package edu.fiuba.algo3.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;

public class HelmetTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        gladiator.upgrade();//NullEquipment upgrades to Helmet
        gladiator.upgrade();//Helmet upgrades to Armor
        gladiator.fightWithBeast();
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(10, energyPoints);//Gladiator with Armor receives 10 damage fighting with a beast
    }
}
