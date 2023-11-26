package edu.fiuba.algo3.modelo.squares;

public class FinishLine extends Square{
    public FinishLine(Square middleSquare) {
        super(new NullEffect());
        this.setFinishLineEffect(middleSquare);
    }

    private void setFinishLineEffect(Square middleSquare) {
        this.effect = new FinishLineEffect(middleSquare, this);
    }

}
