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

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPercentHeight(100.0 / 2);
        grid.getRowConstraints().addAll(rowConstraints, rowConstraints);

        ColumnConstraints colConstraints = new ColumnConstraints();
        colConstraints.setPercentWidth(100.0 / 3);
        grid.getColumnConstraints().addAll(colConstraints, colConstraints, colConstraints);

        grid.add(createDefaultGladiator(), 0, 0);
        grid.add(createDefaultGladiator(), 1, 0);
        grid.add(newAddCard(), 2, 0);
        grid.add(newAddCard(), 0, 1);
        grid.add(newAddCard(), 1, 1);
        grid.add(newAddCard(), 2, 1);

        grid.setPadding(new Insets(10));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(grid);
        mainContainer.getChildren().add(new Button("Start Game"));
        Scene scene = new Scene(mainContainer, 750, 500);

        scene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());

        return scene;
    }

    public VBox newAddCard() {
        VBox aVBox = new VBox();
        aVBox.setPrefHeight(150);
        aVBox.setPrefWidth(75);
        aVBox.getStyleClass().add("gladiator-card");
        aVBox.setAlignment(Pos.CENTER);
        aVBox.setPadding(new Insets(40));
        aVBox.getChildren().add(setAddButton(aVBox));
        return aVBox;
    }
    public Button setAddButton(VBox vBox) {
        Button addButton = new Button("+");
        addButton.getStyleClass().add("plus-sign");
        addButton.setPrefHeight(vBox.getHeight());
        addButton.setPrefWidth(vBox.getWidth());
        addButton.setOnAction(e -> addGladiator(vBox));
        return addButton;
    }
    public VBox createDefaultGladiator() {
        VBox newGladiatorInfo = new VBox();
        newGladiatorInfo.getStyleClass().add("gladiator-card");
        newGladiatorInfo.setAlignment(Pos.CENTER);
        newGladiatorInfo.setPadding(new Insets(40));
        TextField gladiatorNameField = new TextField();
        Label nameLabel = new Label("Nombre");
        nameLabel.setLabelFor(gladiatorNameField);
        newGladiatorInfo.getChildren().add(nameLabel);
        newGladiatorInfo.getChildren().add(gladiatorNameField);
        return newGladiatorInfo;
    }
    public void addGladiator(VBox container) {
        container.getChildren().clear();

        Label nameLabel = new Label("Nombre");
        TextField gladiatorNameField = new TextField();
        nameLabel.setLabelFor(gladiatorNameField);
        Button deleteGladiator = new Button("-");
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