package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.squares.Square;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class MapController {
    private ArrayList<Square> map;
    public MapController( ArrayList<Square> map ) {
        this.map = map;
    }

    public Pane draw() {
        int cols = 10; //this.map.getColumns();
        int rows = 10; //this.map.getRows();
        GridPane mapGridPane = new GridPane();
        this.setUpStyles(mapGridPane);
        this.setUpRows(mapGridPane, rows);
        this.setUpCols(mapGridPane, cols);
        for(int c = 0; c < cols; c ++) {
            for(int r = 0; r < rows; r ++) {
                Position square = new Position(r, c, r*c); //this.map.getPosition(r, c);
                SquareController squareController = new SquareController(square);
                mapGridPane.add(
                    squareController.draw(),
                    c,
                    r
                );
            }
        }
        return mapGridPane;
    }

    private void setUpStyles(Pane pane) {
        pane.getStylesheets().add(getClass().getResource("/styles/map.css").toExternalForm());
        pane.setPrefSize(600, 600);
        pane.getStyleClass().add("map-grid");
    }


    private void setUpRows(GridPane mapGridPane, int rows) {
        for(int i = 0; i < rows; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setPercentHeight(100.0 / rows);
            mapGridPane.getRowConstraints().add(rowConstraints);
        }
    }

    private void setUpCols(GridPane mapGridPane, int cols) {
        for(int i = 0; i < cols; i++) {
            ColumnConstraints columnConstraints = new ColumnConstraints();
            columnConstraints.setPercentWidth(100.0 / cols);
            mapGridPane.getColumnConstraints().add(columnConstraints);
        }
    }
}
