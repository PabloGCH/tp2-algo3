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
}
