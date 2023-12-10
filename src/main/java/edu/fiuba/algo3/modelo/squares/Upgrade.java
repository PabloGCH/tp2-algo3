package edu.fiuba.algo3.modelo.squares;


import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Upgrade implements Effect{
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.upgrade();
    }
    public String getName() {
        return "upgrade";
    }
}

