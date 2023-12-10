package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Food implements Effect {
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.eat();
    }
    public String getName() {
        return "food";
    }
}
