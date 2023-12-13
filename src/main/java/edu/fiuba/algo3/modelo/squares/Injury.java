package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public class Injury implements Effect {
    private ArrayList<EffectObserver> observers = new ArrayList<>();
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.injured();
        this.updateObservers();
    }
    public String getName() {
        return "injury";
    }
    @Override
    public void addObserver(EffectObserver observer) {
        this.observers.add(observer);
    }
    private void updateObservers() {
        for (EffectObserver observer : observers) {
            observer.update(this.getName());
        }
    }
}
