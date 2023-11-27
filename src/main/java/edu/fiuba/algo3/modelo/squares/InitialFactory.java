package edu.fiuba.algo3.modelo.squares;

public class InitialFactory extends PositionFactory{
    public Position createPosition(Effect effect){
        return new Initial();
    }
}
