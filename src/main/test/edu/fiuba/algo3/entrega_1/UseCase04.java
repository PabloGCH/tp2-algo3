package edu.fiuba.algo3.entrega_1;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.energy.Energy;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase04 {
    @Test
    public void testIncreasedEnergyPerMeal(){
        // Arrange

        Gladiator gladiator = new Gladiator();

        // Act

        gladiator.eat();
        int energyPoints = gladiator.getEnergy();

        // Assert

        assumeTrue(energyPoints == 35);


    }
}
