package edu.fiuba.algo3.modelo.gladiator.equipment;

import edu.fiuba.algo3.modelo.gladiator.state.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ShieldSword implements Equipment{

    private static final int DAMAGE_SWORD = 2;
    public Equipment upgrade() {
        return new Key();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_SWORD);
    }

    public State win(State state) {
        return state;
    }

    public String showImage(){
        String equipment = ("/img/pixel-helmet.jpg");
        return equipment;
    }
}
