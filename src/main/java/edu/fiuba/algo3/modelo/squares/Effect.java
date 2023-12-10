package edu.fiuba.algo3.modelo.squares;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public interface Effect {
    public void affect(Gladiator aGladiator);
    public String getName();
}
