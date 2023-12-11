package edu.fiuba.algo3.view;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class LossScene extends Scene {

    public LossScene() {
        super(createContent(), 800, 600);
        getStylesheets().add(getClass().getResource("/finalScene.css").toExternalForm());
    }

    public static VBox createContent() {
        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        String winnerMessage = "Nobody managed to reach Pompeii";
        String winnerMessageLine2 = "You lose";
        Label label1 = new Label(winnerMessage), label2 = new Label(winnerMessageLine2);
        Button restartGame = new Button("Restart game");
        Button restartGameSamePlayers = new Button("Restart game with same players");
        Button exitGame = new Button("Exit");
        exitGame.setOnAction(e -> Platform.exit());
        restartGame.getStyleClass().add("btn");
        restartGameSamePlayers.getStyleClass().add("btn");
        exitGame.getStyleClass().add("btn");
        mainContainer.getChildren().addAll(label1, label2, restartGame, restartGameSamePlayers, exitGame);
        return mainContainer;
    }
}
