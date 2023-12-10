package edu.fiuba.algo3.view;

import java.util.ArrayList;
import java.util.HashMap;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class SquareView {
    private static Image pathImage;
    private static HashMap<String, Image> images;

    public SquareView() {
        SquareView.pathImage = null;
        SquareView.images = new HashMap<String, Image>();
    }


    private void loadPathImage() {
        if (SquareView.pathImage == null) {
            SquareView.pathImage = new Image(getClass().getResource("/img/path.png").toExternalForm());
        }
    }

    private void loadImageByName(String name) {
        var image = SquareView.images.get(name);
        if(image == null && name != "") {
            String path = "/img/" + name + ".png";
            System.out.println(path);
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

        //PATH IMAGE
        Pane square = (Pane) mapGridPane.getChildren().get(col * mapGridPane.getRowCount() + row);
        ImageView pathImageView = new ImageView(pathImage);
        pathImageView.setFitHeight(height);
        pathImageView.setFitWidth(width);
        StackPane pathSquare = new StackPane(pathImageView);
        pathSquare.setId("square" + row + "-" + col);
        pathSquare.setPrefSize(width, height);
        pathSquare.setStyle("-fx-border-color: black; -fx-border-width: 1px");
        mapGridPane.getChildren().remove(square);


        //EFFECTS
        FlowPane effectsPane = new FlowPane();
        effectsPane.setAlignment(Pos.CENTER);

        effectNames.remove("");
        for (String name : effectNames) {
            this.loadImageByName(name);
            ImageView imageView = new ImageView(this.images.get(name));
            imageView.setPreserveRatio(true);
            if(effectNames.size() > 1) {
                imageView.setFitWidth(width / 2);
            } 
            else {
                imageView.setFitWidth(width * 0.75);
            }
            effectsPane.getChildren().add(imageView);
        }
        pathSquare.getChildren().add(effectsPane);

        //GLADIATORS GRID
        FlowPane squareGladiatorGrid = new FlowPane();
        squareGladiatorGrid.setStyle("-fx-padding: 5px;");
        squareGladiatorGrid.setHgap(5);
        squareGladiatorGrid.setVgap(5);
        squareGladiatorGrid.setPrefWrapLength(width);
        pathSquare.getChildren().add(squareGladiatorGrid);
        mapGridPane.add(pathSquare, row, col);
        return squareGladiatorGrid;
    }
}
