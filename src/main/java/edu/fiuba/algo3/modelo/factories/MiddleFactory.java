package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Middle;
import edu.fiuba.algo3.modelo.squares.Square;

public class MiddleFactory extends SquareFactory {
    public Square createSquare(Effect obstacle, Effect prize){
        return new Middle(obstacle, prize);
    }
}