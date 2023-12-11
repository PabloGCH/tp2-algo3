package edu.fiuba.algo3;

import edu.fiuba.algo3.view.VictoryScene;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WinnerScene extends Application {
/*    public Scene winnerScene(String winnerPlayer) {
        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        String winnerMessage = "Felicidades " + winnerPlayer;
        String winnerMessageLine2 = "Has logrado escapar a Pompeya!";
        Label label1 = new Label(winnerMessage), label2 = new Label(winnerMessageLine2);
        Button restartGame = new Button("Reiniciar juego"), restartGameSamePlayers = new Button("Reiniciar juego con mismos jugadores");
        restartGame.getStyleClass().add("btn");
        restartGameSamePlayers.getStyleClass().add("btn");
        mainContainer.getChildren().addAll(label1, label2, restartGame, restartGameSamePlayers);
        Scene scene = new Scene(mainContainer);
        scene.getStylesheets().add(getClass().getResource("/finalScene.css").toExternalForm());
        return scene;
    }*/

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new VictoryScene("Zoilo"));
        stage.show();
    }
}
