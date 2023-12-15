package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import java.util.ArrayList;

public class Upgrade implements Effect{
    private final ArrayList<EffectObserver> observers = new ArrayList<>();
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.upgrade();
        this.updateObservers();
    }
    public String getName() {
        return "upgrade";
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