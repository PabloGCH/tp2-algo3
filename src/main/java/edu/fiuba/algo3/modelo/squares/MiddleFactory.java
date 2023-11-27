package edu.fiuba.algo3.modelo.squares;

public class MiddleFactory extends SquareFactory{
    public Square createSquare(Effect obstacle, Effect prize){
        return new Middle(obstacle, prize);
    }
}