package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class SideBarGladiator implements GladiatorObserver{
    private final Label name;
    private final Label energy;
    private final ImageView equipment;
    private final Label rank;
    private final Label state;
    private final VBox viewRef;
    public SideBarGladiator(){
        this.viewRef = new VBox(5);

        this.name = new Label();
        this.energy = new Label();
        this.equipment = new ImageView();
        this.rank = new Label();
        this.state = new Label();

        this.name.setStyle("-fx-text-fill: blue;");
        this.energy.setStyle("-fx-text-fill: black;");
        this.equipment.setFitHeight(34);
        this.equipment.setFitWidth(128);
        this.rank.setStyle("-fx-text-fill: black;");
        this.state.setStyle("-fx-text-fill: black;");

        this.viewRef.getChildren().addAll(this.name, this.energy, this.equipment, this.rank, this.state);
        this.viewRef.setPadding(new Insets(10,10,10,10));
    }
    @Override
    public void update(int row, int column, int energy, String equipment, String name, String rank, String state) {
        this.name.setText(name);
        this.equipment.setImage(new Image(getClass().getResource("/img/" + equipment + ".png").toExternalForm()));
        this.energy.setText("Energy: " + energy);
        this.rank.setText("Rank: " + rank);
        this.state.setText("State: " + state);
    }
    public VBox view(){
        return this.viewRef;
    }
}