package edu.fiuba.algo3.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

import javafx.animation.ScaleTransition;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class SquareView {
    private static Image pathImage;
    private static HashMap<String, Image> images;
    public SquareView() {
        SquareView.pathImage = null;
        SquareView.images = new HashMap<>();
    }
    private void loadPathImage() {
        if (SquareView.pathImage == null) {
            SquareView.pathImage = new Image(getClass().getResource("/img/path.png").toExternalForm());
        }
    }
    private void loadImageByName(String name) {
        var image = SquareView.images.get(name);
        if(image == null && !Objects.equals(name, "")) {
            String path = "/img/" + name + ".png";
            var newImage = new Image(getClass().getResource(path).toExternalForm());
            SquareView.images.put(name, newImage);
        }
    }
    public Pane addPathToMapGrid(
        int row,
        int col,
        int width,
        int height,
        GridPane mapGridPane,
        ArrayList<String> effectNames
    ) {
        this.loadPathImage();

        Pane square = (Pane) mapGridPane.getChildren().get(col * mapGridPane.getRowCount() + row);
        ImageView pathImageView = new ImageView(pathImage);
        pathImageView.setFitHeight(height);
        pathImageView.setFitWidth(width);
        StackPane pathSquare = new StackPane(pathImageView);
        pathSquare.setId("square" + row + "-" + col);
        pathSquare.setPrefSize(width, height);
        pathSquare.setStyle("-fx-border-color: black; -fx-border-width: 1px");
        mapGridPane.getChildren().remove(square);
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(100), pathSquare);
        double originalScaleX = pathSquare.getScaleX();
        double originalScaleY = pathSquare.getScaleY();
        scaleTransition.setToX(originalScaleX * 1.5);
        scaleTransition.setToY(originalScaleY * 1.5);

        pathSquare.setOnMouseEntered(event -> {
            pathSquare.toFront();
            scaleTransition.playFromStart();
        });

        pathSquare.setOnMouseExited(event -> {
            scaleTransition.stop();
            pathSquare.setScaleX(originalScaleX);
            pathSquare.setScaleY(originalScaleY);
        });

        FlowPane effectsPane = new FlowPane();
        effectsPane.setAlignment(Pos.CENTER);

        effectNames.remove("");
        for (String name : effectNames) {
            this.loadImageByName(name);
            ImageView imageView = new ImageView(SquareView.images.get(name));
            imageView.setPreserveRatio(true);
            if(effectNames.size() > 1) {
                imageView.setFitWidth((double) width / 2);
            } 
            else {
                imageView.setFitWidth(width * 0.75);
            }
            effectsPane.getChildren().add(imageView);
        }
        pathSquare.getChildren().add(effectsPane);

        FlowPane squareGladiatorGrid = new FlowPane();
        squareGladiatorGrid.setStyle("-fx-padding: 5px;");
        squareGladiatorGrid.setHgap(1);
        squareGladiatorGrid.setVgap(1);
        squareGladiatorGrid.setPrefWrapLength(width);
        pathSquare.getChildren().add(squareGladiatorGrid);
        mapGridPane.add(pathSquare, row, col);
        return squareGladiatorGrid;
    }
}