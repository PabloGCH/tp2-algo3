package edu.fiuba.algo3.controller;
import edu.fiuba.algo3.modelo.Resources;
import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.controller.SquareController;
import javafx.scene.layout.*;
import javafx.scene.Scene;

public class MapController {
    private Map map;
    public MapController( Map map ) {
        this.map = map;
    }

    public Pane draw() {
        int cols = 10;
        int rows = 10;

        GridPane mapGridPane = new GridPane();
        mapGridPane.getStylesheets().add(getClass().getResource(Resources.MAP_STYLE_PATH.getValue()).toExternalForm());
        mapGridPane.setPrefSize(600, 600);
        mapGridPane.getStyleClass().add("map-grid");

        this.setUpRows(mapGridPane, rows);
        this.setUpCols(mapGridPane, cols);
        for(int c = 0; c < cols; c ++) {
            for(int r = 0; r < rows; r ++) {
                Position square = this.map.getPosition(r, c);
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
