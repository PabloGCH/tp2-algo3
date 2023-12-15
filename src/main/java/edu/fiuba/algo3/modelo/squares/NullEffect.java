package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class NullEffect implements Effect{
    @Override
    public void affect(Gladiator aGladiator)
    {
    }
    public String getName() {
        return "";
    }
    @Override
    public void addObserver(EffectObserver observer) {
    }
}