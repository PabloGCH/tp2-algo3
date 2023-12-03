package edu.fiuba.algo3.modelo.game;

import java.util.ArrayList;

public class TurnDecider {
    private ArrayList gladiators;
    public TurnDecider(ArrayList gladiators) {
        this.gladiators = gladiators;
    }
    public void finishTurn() {
        var gladiator = gladiators.remove(0);
        gladiators.add(gladiator);
    }
}
