package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.view.LossScene;
import edu.fiuba.algo3.view.VictoryScene;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStateController {
    private static Stage stage;
    private static GameStateController instance;
    private String styles = getClass().getResource("/finalScene.css").toExternalForm();
    private GameStateController(Stage stage) {
        this.stage = stage;
    }
    public static GameStateController getInstance() {
        return instance;
    }
    public static GameStateController getInstance(Stage stage) {
        if (instance == null) {
            instance = new GameStateController(stage);
        }
        return instance;
    }
    public static void showLossScreen() {
        VBox vBox = new LossScene().createContent(stage);
        stage.getScene().setRoot(vBox);
        stage.getScene().getStylesheets().add(getInstance().styles);
    }
    public static void showVictoryScreen(String winner) {
        VBox vBox = new VictoryScene().createContent(stage, winner);
        stage.getScene().setRoot(vBox);
        stage.getScene().getStylesheets().add(getInstance().styles);
    }
}
