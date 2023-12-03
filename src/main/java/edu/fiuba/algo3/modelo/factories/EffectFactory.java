package edu.fiuba.algo3.modelo.factories;

import edu.fiuba.algo3.modelo.squares.*;

public class EffectFactory {
    public Effect createSquare(String type){
        switch (type) {
            case "Fiera":
                return new Beast();
            case "Bacanal":
                return new Bacchanalia();
            case "Lesion":
                return new Injury();
            case "Equipamiento":
                return new Upgrade();
            case "Comida":
                return new Food();
            default:
                return new NullEffect();
        }
    }
}
