package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public abstract class Square implements Position {
    private Position nextPosition;
    protected Effect prize;
    protected Effect obstacle;
    private int x;
    private int y;

    public Square(Effect obstacle, Effect prize) {
        this.prize = prize;
        this.obstacle = obstacle;
        this.nextPosition = this;
        this.x = 0;
        this.y = 0;
    }
    
    public void receivePiece(Gladiator piece){
        piece.runEffect(obstacle);
        piece.runEffect(prize);
    }

    /*
    public int display() {
        return (int) pieces.stream().count();
    }
    */
    
    public Position next() {
        return this.nextPosition;
    }

    public void setNextPosition(Position position) {
        this.nextPosition = position;
    }

    public void positionSelf(PositionCollection collection) {
        collection.setPosition(x, y, this);
    }
}
