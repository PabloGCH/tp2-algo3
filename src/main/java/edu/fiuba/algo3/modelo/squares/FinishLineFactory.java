package edu.fiuba.algo3.modelo.squares;

public class FinishLineFactory extends SquareFactory{
    public Square createSquare(Effect obstacle, Effect prize){
        return new FinishLine(obstacle, prize);
    }
}