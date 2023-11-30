package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.controller.MapController;
import edu.fiuba.algo3.controller.StartButtonController;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.PositionCollection;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    ArrayList<TextField> nameFields = new ArrayList<TextField>();
    @Override
    public void start(Stage stage) {

        Scene initialScene = initialScene(stage);
        initialScene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());
        stage.setScene(initialScene);
        stage.setResizable(false);
        stage.show();
    }

    public void displayMap() {

    }

    public Scene mapScene() {
        MapFacade mapFacade = new MapFacade();

        edu.fiuba.algo3.modelo.map.Map map =
        new edu.fiuba.algo3.modelo.map.Map(
            15,
            15,
            new ArrayList<Position>()
        ); //SHOULD BE REPLACED BY "mapFacade.loadMap()"
        
        MapController mapController = new MapController(map);
        return new Scene(mapController.draw());
    }

    public Scene initialScene(Stage stage) {
        VBox mainContainer = new VBox();
        Label invalidNamesText = new Label("Los nombres deben ser únicos y de al menos 4 caracteres");
        invalidNamesText.setVisible(false);
        invalidNamesText.setStyle("-fx-text-fill: red;");
        mainContainer.getChildren().add(invalidNamesText);
        GridPane grid = new GridPane();

        grid.add(createDefaultGladiator(), 0, 0);
        grid.add(createDefaultGladiator(), 1, 0);
        grid.add(newAddCard(), 2, 0);
        grid.add(newAddCard(), 0, 1);
        grid.add(newAddCard(), 1, 1);
        grid.add(newAddCard(), 2, 1);

        grid.setPadding(new Insets(10));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(grid);
        Button startButton = new Button("StartGame");
        startButton.getStyleClass().add("start-game-btn");
        startButton.setOnAction(event -> {
            invalidNamesText.setVisible(false);
            StartButtonController controller = new StartButtonController();
            if (controller.validateNames(this.nameFields)) {
                stage.setScene(mapScene());
            }
            invalidNamesText.setVisible(true);
        });
        startButton.getStyleClass().add("btn");
        mainContainer.getChildren().add(startButton);
        mainContainer.setPadding(new Insets(0, 0, 10, 0));
        Scene scene = new Scene(mainContainer);

        scene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());

        return scene;
    }

    public VBox newAddCard() {
        VBox aVBox = new VBox();
        aVBox.setPrefSize(150, 150);
        aVBox.getStyleClass().add("gladiator-card");
        aVBox.setAlignment(Pos.CENTER);
        aVBox.setPadding(new Insets(5));
        aVBox.getChildren().add(setAddButton(aVBox));
        return aVBox;
    }
    public Button setAddButton(VBox vBox) {
        Button addButton = new Button("+");
        addButton.getStyleClass().add("plus-sign");
        addButton.getStyleClass().add("btn");
        addButton.setOnAction(e -> addGladiator(vBox));
        return addButton;
    }
    public VBox createDefaultGladiator() {
        VBox newGladiatorInfo = new VBox();
        newGladiatorInfo.setPrefSize(150, 150);
        newGladiatorInfo.getStyleClass().add("gladiator-card");
        newGladiatorInfo.setAlignment(Pos.CENTER);
        newGladiatorInfo.setPadding(new Insets(5));
        TextField gladiatorNameField = new TextField();
        this.nameFields.add(gladiatorNameField);
        gladiatorNameField.getStyleClass().add("name-field");
        Label nameLabel = new Label("Nombre");
        nameLabel.getStyleClass().add("name-label");
        nameLabel.setLabelFor(gladiatorNameField);
        newGladiatorInfo.getChildren().add(nameLabel);
        newGladiatorInfo.getChildren().add(gladiatorNameField);
        return newGladiatorInfo;
    }
    public void addGladiator(VBox container) {
        container.getChildren().clear();

        Label nameLabel = new Label("Nombre");
        TextField gladiatorNameField = new TextField();
        nameLabel.getStyleClass().add("name-label");
        gladiatorNameField.getStyleClass().add("name-field");
        this.nameFields.add(gladiatorNameField);
        nameLabel.setLabelFor(gladiatorNameField);
        Button deleteGladiator = new Button("-");
        deleteGladiator.getStyleClass().add("btn");
        container.getChildren().add(nameLabel);
        container.getChildren().add(gladiatorNameField);
        container.getChildren().add(deleteGladiator);
        deleteGladiator.setOnAction(e -> removeGladiator(container, gladiatorNameField));
    }

    public void removeGladiator(VBox gladiatorField, TextField nameField) {
        gladiatorField.getChildren().clear();
        gladiatorField.getChildren().add(setAddButton(gladiatorField));
        this.nameFields.remove(nameField);
    }

    public static void main(String[] args) {
        launch();
    }

}