package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import java.util.ArrayList;

public class TurnDecider {
    private final ArrayList<Gladiator> gladiators;
    public TurnDecider(ArrayList gladiators) {
        this.gladiators = gladiators;
    }
    public void finishTurn() {
        Gladiator gladiator = gladiators.remove(0);
        gladiator.refreshState();
        gladiators.add(gladiator);
        System.out.println("\nTurn ended \n");
    }
}