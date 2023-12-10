package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SideBarGladiator implements GladiatorObserver{

    private Label name;
    private Label energy;
    private Label equipment;
    private Label rank;
    private Label state;
    private VBox viewRef;

    public SideBarGladiator(){
        this.viewRef = new VBox(5);

        this.name = new Label();
        this.energy = new Label();
        this.equipment = new Label();
        this.rank = new Label();
        this.state = new Label();

        this.name.setStyle("-fx-text-fill: blue;");
        this.energy.setStyle("-fx-text-fill: black;");
        this.equipment.setStyle("-fx-text-fill: black;");
        this.rank.setStyle("-fx-text-fill: black;");
        this.state.setStyle("-fx-text-fill: black;");

        this.viewRef.getChildren().addAll(this.name, this.energy, this.equipment, this.rank, this.state);
        this.viewRef.setPadding(new Insets(10,10,10,10));
    }

    @Override
    public void update(int row, int columnm, int energy, String equipment, String name, String rank, String state) {
        this.name.setText(name);
        this.equipment.setText("Equipment: " + equipment);
        this.energy.setText("Energy: " + energy + "");
        this.rank.setText("Rank: " + rank);
        this.state.setText("State: " + state);
    }
    
    public VBox view(){
        return this.viewRef;
    }
}
