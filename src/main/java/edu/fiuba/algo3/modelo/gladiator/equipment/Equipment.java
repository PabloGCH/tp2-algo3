package edu.fiuba.algo3.modelo.gladiator.equipment;


import edu.fiuba.algo3.modelo.gladiator.state.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public interface Equipment {
    public Equipment upgrade();
    public int receiveAttack(int energyPoints);
    State win(State state);
    public String showImage();
}

