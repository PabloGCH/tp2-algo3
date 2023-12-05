package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Effect;
import edu.fiuba.algo3.modelo.squares.Upgrade;

public class UpgradeFactory extends EffectFactory {
    public Effect createEffect(){
        return new Upgrade();
    }
}