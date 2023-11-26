package edu.fiuba.algo3.modelo.squares;
import edu.fiuba.algo3.modelo.squares.PositionCollection;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public interface Position {
    public void setNextPosition(Position position);
    public Position next();
    public void receivePiece(Gladiator piece);
    public void removePiece(Gladiator piece);
    public void positionSelf(PositionCollection collection);
}
