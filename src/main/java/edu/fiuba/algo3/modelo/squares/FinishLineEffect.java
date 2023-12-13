package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import java.util.ArrayList;

public class FinishLineEffect implements Effect{
    private ArrayList<EffectObserver> observers = new ArrayList<>();
    private Position middlePosition = new Position(0, 0, 0);
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.tryToWin(middlePosition);
        this.updateObservers();
    }
    public void setMiddlePosition(Position aPosition) {
        this.middlePosition = aPosition;
    }
    public String getName() {
        return "finishline";
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