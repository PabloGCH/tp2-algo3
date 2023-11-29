package edu.fiuba.algo3.modelo.squares;

public class InitialEffectFactory extends  EffectFactory{
    public Effect createEffect(){
        return new InitialEffect();
    }
}