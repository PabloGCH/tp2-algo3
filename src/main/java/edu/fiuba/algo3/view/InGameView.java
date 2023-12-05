package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.Square;
import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InGameView {
    public void displayInGameScene(Stage stage) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        stage.setResizable(true);
        stage.setMaximized(true);
        double gridSize = Math.min(stage.getHeight(), stage.getWidth());
        Game aGame = Game.getInstance();
        Dimension2D dimensions = new MapFacade().mapDimensions();
        int width = (int) dimensions.getWidth();
        int height = (int) dimensions.getHeight();
        GridPane mapGridPane = new GridPane();
        ArrayList<Square> path = aGame.getPath();
        for (int column = 0; column < width; column++) {
            for (int row = 0; row < height; row++) {
                StackPane square = new StackPane();
                square.setPrefSize(gridSize / width, gridSize / height);
                mapGridPane.add(square, row, column);
            }
        }
        Image pathImage = new Image(getClass().getResource("/img/path.png").toExternalForm());
        for (Square square : path) {
            Dimension2D coordinates = square.getPosition().coordinates();
            int xPosition = (int) coordinates.getWidth() - 1, yPosition = (int) coordinates.getHeight() - 1;
            Pane stackPane = (Pane) mapGridPane.getChildren().get(yPosition * mapGridPane.getRowCount() + xPosition);
            ImageView pathImageView = new ImageView(pathImage);
            pathImageView.setFitHeight(gridSize / height);
            pathImageView.setFitWidth(gridSize / width);
            StackPane newPane = new StackPane(pathImageView);
            newPane.setPrefSize(gridSize / width, gridSize / height);
            newPane.setStyle("-fx-border-color: black; -fx-border-width: 1px");
            mapGridPane.getChildren().remove(stackPane);
            mapGridPane.add(newPane, xPosition, yPosition);
        }
        /*for(int c = 0; c < width; c ++) {
            for(int r = 0; r < height; r ++) {
                Position square = new Position(r, c, r*c); //this.map.getPosition(r, c);
                SquareController squareController = new SquareController(square);
                mapGridPane.add(
                        squareController.draw(),
                        c,
                        r
                );
            }
        }*/
        stage.getScene().setRoot(mapGridPane);
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/map.css").toExternalForm());
    }
}
