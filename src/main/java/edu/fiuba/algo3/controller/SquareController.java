package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.Resources;
import edu.fiuba.algo3.modelo.squares.Position;
import javafx.scene.layout.*;

public class SquareController {
    private Position square;
    public SquareController( Position square ) {
        this.square = square;
    }

    public Pane draw() {
        Pane squarePane = new Pane();
        squarePane.getStylesheets().add(getClass().getResource(Resources.SQUARE_STYLE_PATH.getValue()).toExternalForm());
        squarePane.getStyleClass().add("square");
        return squarePane;
    }
}
