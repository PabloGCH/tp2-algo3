package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.Sound;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LossScene extends VBox {
    public static VBox createContent(Stage stage) {
        VBox mainContainer = new VBox();
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getStyleClass().add("main-container");
        String winnerMessage = "Nobody managed to reach Pompeii";
        String winnerMessageLine2 = "You lose";
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
        Sound.getInstance().modifyEffectVolume(0);
        Sound.getInstance().playMusicOnce("lose.mp3");
        return mainContainer;
    }
}