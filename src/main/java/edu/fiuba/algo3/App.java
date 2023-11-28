package edu.fiuba.algo3;

import java.util.ArrayList;
import java.util.Map;

import edu.fiuba.algo3.controller.MapController;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.PositionCollection;
import edu.fiuba.algo3.modelo.squares.Square;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;



/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        stage.setScene(mapScene());
        stage.show();
    }

    public void displayMap() {

    }

    public Scene mapScene() {
        edu.fiuba.algo3.modelo.map.Map map =
        new edu.fiuba.algo3.modelo.map.Map(
            10,
            10,
            new ArrayList<Position>()
        );
        MapController mapController = new MapController(map);
        return new Scene(mapController.draw());
    }

    public Scene initialScene() {
        Button addButton = new Button("+");
        HBox anHBox = new HBox();
        anHBox.setPrefSize(500, 250);
        anHBox.getChildren().add(addButton);
        addButton.setOnAction(e -> addGladiator(addButton, anHBox));
        return new Scene(anHBox);
    }

    public void addGladiator(Button addButton, HBox container) {
        VBox newGladiatorInfo = new VBox();
        TextField gladiatorNameField = new TextField();
        Label nameLabel = new Label("Nombre");
        nameLabel.setLabelFor(gladiatorNameField);
        Button deleteGladiator = new Button("-");
        newGladiatorInfo.getChildren().add(nameLabel);
        newGladiatorInfo.getChildren().add(gladiatorNameField);
        newGladiatorInfo.getChildren().add(deleteGladiator);
        container.getChildren().add(newGladiatorInfo);
        deleteGladiator.setOnAction(e -> removeGladiator(newGladiatorInfo, container, addButton));
    }

    public void removeGladiator(VBox gladiatorField, HBox mainContainer, Button addButton) {
        mainContainer.getChildren().remove(gladiatorField);
    }

    public static void main(String[] args) {
        launch();
    }

}