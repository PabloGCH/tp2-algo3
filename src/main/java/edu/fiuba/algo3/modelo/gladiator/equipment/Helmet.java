package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Helmet implements Equipment{
    private static final int DAMAGE_HELMET = 15;
    public Equipment upgrade() {
        return new Armor();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_HELMET);
    }

    public State win(State state) {
        return state;
    }

    public String showImage(){
        String equipment = ("Casco");
        return equipment;
    }
}
