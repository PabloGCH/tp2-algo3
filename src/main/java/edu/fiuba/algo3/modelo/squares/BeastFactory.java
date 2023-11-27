package edu.fiuba.algo3.modelo.squares;

public class BeastFactory extends EffectFactory{
    public Effect createEffect(){
        return new Beast();
    }
}
