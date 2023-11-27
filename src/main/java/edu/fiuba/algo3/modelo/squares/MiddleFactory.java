package edu.fiuba.algo3.modelo.squares;

public class MiddleFactory extends PositionFactory{
    public Position createPosition(Effect effect){
        return new Middle(effect);
    }
}
