package edu.fiuba.algo3.modelo.squares;

public class NullEffectFactory extends  EffectFactory{
    public Effect createEffect(){
        return new NullEffect();
    }
}
