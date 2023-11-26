package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

public abstract class Square implements Position {
    private ArrayList<Gladiator> pieces = new ArrayList();
    private Position nextPosition;
    protected Effect effect;

    public Square(Effect anEffect) {
        this.effect = anEffect;
        this.nextPosition = this;
    }
    
    public void receivePiece(Gladiator piece){
        if(pieces.contains(piece)) return;
        this.pieces.add(piece);
        this.effect.affect(piece);
    }

    public void removePiece(Gladiator piece) {
        pieces.remove(piece);
    }

    public int display() {
        return (int) pieces.stream().count();
    }

    public Position next() {
        return this.nextPosition;
    }

    public void setNextPosition(Position position) {
        this.nextPosition = position;
    }
}
