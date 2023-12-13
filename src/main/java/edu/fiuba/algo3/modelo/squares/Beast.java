package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public class Beast implements Effect{
    private ArrayList<EffectObserver> observers = new ArrayList<>();
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.fightWithBeast();
        this.updateObservers();
    }
    public String getName() {
        return "beast";
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
