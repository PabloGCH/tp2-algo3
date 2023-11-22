package edu.fiuba.algo3.equipmentTest;
import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.Initial;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;

public class KeyTest {
    @Test void upgradeReturnsHelmet(){
        //Arrange
        Gladiator gladiator = new Gladiator(); //Should start with 20 energy
        Square initialSquare = new Initial();
        initialSquare.receiveGladiator(gladiator);

        //Act
        gladiator.upgrade();//NullEquipment upgrades to Helmet
        gladiator.upgrade();//Helmet upgrades to Armor
        gladiator.upgrade();//Armor upgrades to ShieldSword
        gladiator.upgrade();//ShieldSword upgrades to Key
        gladiator.upgrade();//Key upgrades to Key
        gladiator.fightWithBeast();
        var energy = gladiator.getEnergy();
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(20, energyPoints);//Gladiator with Key receives 0 damage fighting with a beast
    }
    @Test void receiveAttackReturnsCorrectDamage(){
        //Arrange
        Key newEquipment = new Key();
        Energy energy = new Energy(20);
        //Act
        energy = newEquipment.receiveAttack(energy);
        int energyPoints = energy.getPoints();
        //Assert
        assertEquals(20, energyPoints);
    }
}
