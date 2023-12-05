package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Food;

public class FoodFactory extends EffectFactory {
    public Effect createEffect(){
        return new Food();
    }
}
