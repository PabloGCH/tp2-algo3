package edu.fiuba.algo3.modelo.gladiator.equipment;


import edu.fiuba.algo3.modelo.gladiator.state.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class NullEquipment implements Equipment {
    private static final int DAMAGE_NULL_EQUIPMENT = 20;
    public Equipment upgrade() {
        return new Helmet();
    }

    public int receiveAttack(int energy){
        return (energy - DAMAGE_NULL_EQUIPMENT);
    }

    public State win(State state) {
        return state;
    }

    public String showName(){
        String equipment = ("Without equipment");
        return equipment;
    }
}
