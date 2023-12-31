package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import java.util.ArrayList;
import java.util.Objects;

public class Square {
    private final Position position;
    protected Effect prize;
    protected Effect obstacle;

    public Square(Effect obstacle, Effect prize, Position aPosition) {
        this.prize = prize;
        this.obstacle = obstacle;
        this.position = aPosition;
    }
    public void affect(Gladiator gladiator){
        gladiator.positionate(position);
        gladiator.runEffect(prize);
        gladiator.runEffect(obstacle);
    }
    public Position getPosition() {
        return this.position;
    }
    public ArrayList<String> getEffectNames() {
        ArrayList<String> names = new ArrayList<>();
        String obstacleName = this.obstacle.getName();
        if(!Objects.equals(obstacleName, "")) names.add(obstacleName);
        String prizeName = this.prize.getName();
        if(!Objects.equals(prizeName, "")) names.add(prizeName);
        return names;
    }
    public void addEffectObserver(EffectObserver observer) {
        this.prize.addObserver(observer);
        this.obstacle.addObserver(observer);
    }
}