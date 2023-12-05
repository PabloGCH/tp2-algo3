package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.squares.Bacchanalia;
import edu.fiuba.algo3.modelo.squares.Effect;

public class BacchanaliaFactory extends EffectFactory {
    public Effect createEffect(){
        return new Bacchanalia();
    }
}
