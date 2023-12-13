package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.game.GameEndController;
import edu.fiuba.algo3.view.LossScene;
import edu.fiuba.algo3.view.VictoryScene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GameStateController implements GameEndController {
    private static Stage stage;
    private static GameStateController instance;
    private final String styles = getClass().getResource("/styles/finalScene.css").toExternalForm();
    private GameStateController(Stage stage) {
        GameStateController.stage = stage;
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
    public void showLossScreen() {
        VBox vBox = LossScene.createContent(stage);
        stage.getScene().setRoot(vBox);
        stage.getScene().getStylesheets().add(getInstance().styles);
    }
    public void showVictoryScreen(String winner) {
        VBox vBox = VictoryScene.createContent(stage, winner);
        stage.getScene().setRoot(vBox);
        stage.getScene().getStylesheets().add(getInstance().styles);
    }
}