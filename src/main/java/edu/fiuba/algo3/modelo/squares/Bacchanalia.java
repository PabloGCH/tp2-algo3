package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Bacchanalia implements Effect{
    @Override
    public void affect(Gladiator aGladiator) {
        Dice aDice = new Dice();
        int amountOfWineGlasses = aDice.throwDice();
        aGladiator.drinkWine(amountOfWineGlasses);
    }
}
