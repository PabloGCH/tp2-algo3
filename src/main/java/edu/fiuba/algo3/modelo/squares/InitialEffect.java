package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class InitialEffect implements Effect {
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.setInitialEnergy(new Energy(20));
    }
}
