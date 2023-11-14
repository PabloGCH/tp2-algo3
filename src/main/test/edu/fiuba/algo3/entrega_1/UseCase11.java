package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class UseCase11 {
    public void testGladiatorWithKeyUpgradeHasNoEffect(){
        // Arrange

        Gladiator gladiator = new Gladiator();

        // Act

        gladiator.upgrade();//Gets Helmet
        gladiator.upgrade();//Gets Armor
        gladiator.upgrade();//Gets ShieldSword
        gladiator.upgrade();//Gets Key
        gladiator.upgrade();
        Equipment equipment = gladiator.getEquipment();

        // Assert

        assumeTrue(equipment instanceof Key);
    }
}
