<<<<<<<< HEAD:src/main/java/edu/fiuba/algo3/modelo/position/Position.java
<<<<<<<< HEAD:src/main/java/edu/fiuba/algo3/modelo/position/Position.java
package edu.fiuba.algo3.modelo.position;
========
package edu.fiuba.algo3.modelo;
>>>>>>>> 74291eb ("position" package change):src/main/java/edu/fiuba/algo3/modelo/Position.java
========
package edu.fiuba.algo3.modelo.squares;
>>>>>>>> 7246f34 (merge):src/main/java/edu/fiuba/algo3/modelo/squares/Position.java


import javafx.geometry.Dimension2D;

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
        if (pathSize <= stepsForward + this.pathLocation){
            return (pathSize - 1);
        }
        else {
            return (this.pathLocation + stepsForward);
        }
    }
    public Dimension2D coordinates() {
        return new Dimension2D(this.x, this.y);
    }
}
