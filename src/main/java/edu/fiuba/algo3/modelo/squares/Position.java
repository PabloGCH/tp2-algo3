package edu.fiuba.algo3.modelo.squares;


public class Position {

    int x,y;
    int pathLocation;

    public Position(int x, int y, int pathPosition){
        this.pathLocation = pathPosition;
        this.x = x;
        this.y = y;
    }

    public boolean comparePosition(Position aPosition){
        return (this.pathLocation == aPosition.pathLocation);
    }
    public int moveFoward(int stepsForward, int pathSize){
        if (pathSize >= stepsForward + this.pathLocation){
            return (pathSize - 1);
        }
        else {
            return (this.pathLocation + stepsForward);
        }
    }
}
