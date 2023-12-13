package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.Sound;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VictoryScene extends VBox {
    public static VBox createContent(Stage stage, String winnerPlayer) {
        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        String winnerMessage = "Congratulations " + winnerPlayer + "!";
        String winnerMessageLine2 = "You managed to reach Pompeii";
        Label label1 = new Label(winnerMessage), label2 = new Label(winnerMessageLine2);
        Button restartGame = new Button("Restart game");
        restartGame.setOnAction(e -> {
            Game.getInstance().restartGame();
            stage.getScene().setRoot(new InitialView().initialScene(stage));
            stage.setMaximized(false);
            stage.setResizable(false);
        });
        Button restartGameSamePlayers = new Button("Restart game with same players");
        restartGameSamePlayers.setOnAction(e -> {
            Game.getInstance().restartGameWithSamePlayers();
            try {
                new InGameView().displayInGameScene(stage);
            } catch (MapFileNotFound ex) {
                throw new RuntimeException(ex);
            } catch (MapFileFailedToOpenOrClose ex) {
                throw new RuntimeException(ex);
            } catch (MapFileCouldNotBeParsed ex) {
                throw new RuntimeException(ex);
            } catch (InvalidMapFile ex) {
                throw new RuntimeException(ex);
            }
        });
        Button exitGame = new Button("Exit");
        exitGame.setOnAction(e -> Platform.exit());
        restartGame.getStyleClass().add("btn");
        restartGameSamePlayers.getStyleClass().add("btn");
        exitGame.getStyleClass().add("btn");
        mainContainer.getChildren().addAll(label1, label2, restartGame, restartGameSamePlayers, exitGame);
        Sound.getInstance().playMusic("victory.mp3");
        return mainContainer;
    }
}
