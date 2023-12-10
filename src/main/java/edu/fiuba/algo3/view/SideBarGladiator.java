package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SideBarGladiator implements GladiatorObserver{

    private Label name;
    private Label energy;
    private Label equipment;
    private VBox viewRef;

    public SideBarGladiator(){
        this.viewRef = new VBox(5);

        this.name = new Label();
        this.energy = new Label();
        this.equipment = new Label();

        this.name.setStyle("-fx-text-fill: blue;");
        this.energy.setStyle("-fx-text-fill: black;");
        this.equipment.setStyle("-fx-text-fill: black;");

        this.viewRef.getChildren().addAll(this.name, this.energy, this.equipment);
        this.viewRef.setPadding(new Insets(10,10,10,10));
    }

    @Override
    public void update(int row, int columnm, int energy, String equipment, String name) {
        this.name.setText(name);
        this.equipment.setText("Equipment: " + equipment);
        this.energy.setText("Energy: " + energy + "");
    }
    
    public VBox view(){
        return this.viewRef;
    }
}
