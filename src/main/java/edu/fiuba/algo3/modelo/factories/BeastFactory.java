package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Beast;
import edu.fiuba.algo3.modelo.squares.Effect;

public class BeastFactory extends EffectFactory {
    public Effect createEffect(){
        return new Beast();
    }
}
