package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public interface Effect extends EffectObservable {
    void affect(Gladiator aGladiator);
    String getName();
}