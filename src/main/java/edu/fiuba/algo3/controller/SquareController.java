package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.position.Position;
import javafx.scene.layout.*;

public class SquareController {
    private final String SQUARE_STYLE_PATH = "/styles/square.css";
    private Position square;
    public SquareController( Position square ) {
        this.square = square;
    }

    public Pane draw() {
        Pane squarePane = new Pane();
        squarePane.getStylesheets().add(getClass().getResource(SQUARE_STYLE_PATH).toExternalForm());
        squarePane.getStyleClass().add("square");
        return squarePane;
    }
}
