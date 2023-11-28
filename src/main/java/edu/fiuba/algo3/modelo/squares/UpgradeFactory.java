package edu.fiuba.algo3.modelo.squares;

public class UpgradeFactory extends  EffectFactory{
    public Effect createEffect(){
        return new Upgrade();
    }
}