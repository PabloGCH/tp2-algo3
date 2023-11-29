package edu.fiuba.algo3.modelo.RandomResult;

import edu.fiuba.algo3.modelo.Dice;

public class DiceFactory extends RandomResultFactory{
    @Override
    public RandomResult createRandomGenerator() {
        return new Dice();
    }
}
