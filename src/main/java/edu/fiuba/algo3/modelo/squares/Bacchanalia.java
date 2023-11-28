package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.RandomResult.DiceFactory;
import edu.fiuba.algo3.modelo.RandomResult.RandomResult;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Bacchanalia implements Effect{
    private final RandomResult randomResult;
    public Bacchanalia(){
        var diceFactory = new DiceFactory();
        RandomResult dice = diceFactory.createRandomGenerator();
        this.randomResult = dice;
    }
    @Override
    public void affect(Gladiator aGladiator) {
        int amountOfWineGlasses = this.randomResult.throwNumber();
        aGladiator.drinkWine(amountOfWineGlasses);
    }
}
