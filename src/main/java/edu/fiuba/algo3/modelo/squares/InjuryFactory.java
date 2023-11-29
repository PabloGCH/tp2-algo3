package edu.fiuba.algo3.modelo.squares;

public class InjuryFactory extends  EffectFactory{
    public Effect createEffect(){
        return new Injury();
    }
}
