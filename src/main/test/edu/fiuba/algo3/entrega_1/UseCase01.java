package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase01 {
    @Test
    public void testGladiatorStartsWithCorrectEnergyAndEquipment() {
        //Arrange
        Gladiator gladiator = new Gladiator();
        //Act
        int energyPoints = gladiator.getEnergyAsInteger();
        Equipment equipment = gladiator.getEquipment();
        //Assert
        assumeTrue(equipment instanceof NullEquipment)
        assumeTrue(energyPoints == 20);
    }
}
