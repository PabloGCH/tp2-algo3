package edu.fiuba.algo3.modelo.squares;

public class InitialFactory extends SquareFactory{
    public Square createSquare(Effect obstacle, Effect prize){
        return new Initial();
    }
}
