package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Bacchanalia implements Effect{
    private RandomResult randomResult;
    public Bacchanalia(RandomResult newRandomResult){
        this.randomResult = newRandomResult;
    }
    @Override
    public void affect(Gladiator aGladiator) {
        int amountOfWineGlasses = this.randomResult.throwNumber();
        aGladiator.drinkWine(amountOfWineGlasses);
    }
}
