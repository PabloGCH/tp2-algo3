package edu.fiuba.algo3.modelo.squares;

public class FinishLine extends Square{
    public FinishLine(Square middleSquare) {
        super(new FinishLineEffect(middleSquare));
    }
}
