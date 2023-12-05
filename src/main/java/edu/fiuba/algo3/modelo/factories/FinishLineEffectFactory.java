package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.FinishLineEffect;

public class FinishLineEffectFactory extends EffectFactory {
    public Effect createEffect(){
        return new FinishLineEffect();
    }
}
