package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public abstract class Square {
    private ArrayList<Gladiator> gladiators = new ArrayList();
    protected Effect effect;
    public Square(Effect anEffect) {
        this.effect = anEffect;
    }
    public void receiveGladiator(Gladiator aGladiator){
        this.gladiators.add(aGladiator);
        this.effect.affect(aGladiator);
    }
    public void unsetGladiator(Gladiator aGladiator) {
        if (gladiators.contains(aGladiator)) {
            gladiators.remove(aGladiator);
        }
    }
    public int display() {
        return (int) gladiators.stream().count();
    }
}
