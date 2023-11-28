package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class FinishLineEffect implements Effect{
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.worthy();
        /*if (aGladiator.completeArmament() == true) {
            aGladiator.gameOver();
        }*/
    }
}
