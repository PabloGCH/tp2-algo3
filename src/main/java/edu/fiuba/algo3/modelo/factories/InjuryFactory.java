package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Injury;

public class InjuryFactory extends EffectFactory {
    public Effect createEffect(){
        return new Injury();
    }
}
