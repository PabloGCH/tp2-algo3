package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public class Food implements Effect {
    private ArrayList<EffectObserver> observers = new ArrayList<>();
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.eat();
        this.updateObservers();
    }
    public String getName() {
        return "food";
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