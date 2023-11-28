package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {

        Scene initialScene = initialScene();
        initialScene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());
        stage.setScene(initialScene);
        stage.setResizable(false);
        stage.show();
    }

    public void displayMap() {

    }

    public Scene initialScene() {
        VBox mainContainer = new VBox();
        GridPane grid = new GridPane();

//        RowConstraints rowConstraints = new RowConstraints();
//        rowConstraints.setPercentHeight(300.0 / 2);
//        grid.getRowConstraints().addAll(rowConstraints, rowConstraints);
//
//        ColumnConstraints colConstraints = new ColumnConstraints();
//        colConstraints.setPercentWidth(300.0 / 3);
//        grid.getColumnConstraints().addAll(colConstraints, colConstraints, colConstraints);

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
        startButton.getStyleClass().add("btn");
        mainContainer.getChildren().add(startButton);
        mainContainer.setPadding(new Insets(0, 0, 10, 0));
        Scene scene = new Scene(mainContainer);

        scene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());

        return scene;
    }

    public VBox newAddCard() {
        VBox aVBox = new VBox();
        aVBox.setPrefSize(100, 150);
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
        newGladiatorInfo.setPrefSize(100, 150);
        newGladiatorInfo.getStyleClass().add("gladiator-card");
        newGladiatorInfo.setAlignment(Pos.CENTER);
        newGladiatorInfo.setPadding(new Insets(5));
        TextField gladiatorNameField = new TextField();
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
        nameLabel.setLabelFor(gladiatorNameField);
        Button deleteGladiator = new Button("-");
        deleteGladiator.getStyleClass().add("btn");
        container.getChildren().add(nameLabel);
        container.getChildren().add(gladiatorNameField);
        container.getChildren().add(deleteGladiator);
        deleteGladiator.setOnAction(e -> removeGladiator(container));
    }

    public void removeGladiator(VBox gladiatorField) {
        gladiatorField.getChildren().clear();
        gladiatorField.getChildren().add(setAddButton(gladiatorField));
    }

    public static void main(String[] args) {
        launch();
    }

}