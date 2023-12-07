package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;

public class FinishLineEffect implements Effect{
    private Position middlePosition = new Position(0, 0, 0);
    @Override
    public void affect(Gladiator aGladiator) {
        aGladiator.tryToWin(middlePosition);
    }

    public void setMiddlePosition(Position aPosition) {
        this.middlePosition = aPosition;
    }
}
