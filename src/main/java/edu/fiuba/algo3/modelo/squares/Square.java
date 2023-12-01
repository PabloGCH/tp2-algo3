package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public abstract class Square{
    private Position position;
    protected Effect prize;
    protected Effect obstacle;

    public Square(Effect obstacle, Effect prize,Position aPosition) {
        this.prize = prize;
        this.obstacle = obstacle;
        this.position = aPosition;
    }

    public void affect(Gladiator gladiator){
        gladiator.runEffect(obstacle);
        gladiator.runEffect(prize);
        gladiator.positionate(position);
    }

    /*
    public int display() {
        return (int) pieces.stream().count();
    }
    */
}
