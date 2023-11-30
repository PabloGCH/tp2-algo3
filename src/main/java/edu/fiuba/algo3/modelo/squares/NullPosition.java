package edu.fiuba.algo3.modelo.squares;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class NullPosition implements Position {
    public void setNextPosition(Position position) {}
   // public void removePiece(Gladiator piece) {}
    public void receivePiece(Gladiator piece) {}
    public Position next() {
        return this;
    }
    public void positionSelf(PositionCollection collection) {}
}
