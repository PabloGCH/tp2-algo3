package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Square;

public abstract class SquareFactory{
    public abstract Square createSquare(Effect obstacle, Effect prize);
}
