package edu.fiuba.algo3.modelo.squares;

public class BacchanaliaFactory extends  EffectFactory{
    public Effect createEffect(){
        return new Bacchanalia();
    }
}
