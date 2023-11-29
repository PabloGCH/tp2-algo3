package edu.fiuba.algo3.modelo.squares;

public class FoodFactory extends EffectFactory{
    public Effect createEffect(){
        return new Food();
    }
}
