package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;

import java.util.ArrayList;

public class Square{
    private Position position;
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
        ArrayList<String> names = new ArrayList<String>();
        String obstacleName = this.obstacle.getName();
        if(obstacleName != "") names.add(obstacleName);
        String prizeName = this.prize.getName();
        if(prizeName != "") names.add(prizeName);
        return names;
    }
}
