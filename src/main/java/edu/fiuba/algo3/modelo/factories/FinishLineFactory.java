package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.FinishLine;
import edu.fiuba.algo3.modelo.squares.Square;

public class FinishLineFactory extends SquareFactory {
    public Square createSquare(Effect obstacle, Effect prize){
        return new FinishLine(obstacle, prize);
    }
}