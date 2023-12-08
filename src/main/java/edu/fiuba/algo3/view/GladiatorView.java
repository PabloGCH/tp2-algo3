package edu.fiuba.algo3.view;

import java.util.ArrayList;
import java.util.HashMap;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class GladiatorView implements GladiatorObserver {
    private Pane parentView;
    private Pane viewRef;
    private HashMap<String, Pane> gladiatorGrids;

    public void update(int row, int column, int energy) {
        Pane squareView = gladiatorGrids.get(row + "-" + column);
        if(parentView != null) parentView.getChildren().remove(viewRef);
        squareView.getChildren().add(viewRef);
        parentView = squareView;
    }

    public Pane view() {
        return viewRef;
    }

    public GladiatorView(HashMap<String, Pane> gladiatorGrids) {
        viewRef = this.newGladiatorView();
        this.parentView = null;
        this.gladiatorGrids = gladiatorGrids;
    }

    private Pane newGladiatorView() {
        Pane gladiatorView = new Pane();
        Pane piece = new Pane();
        piece.setMinSize(20, 20);;
        piece.setStyle("-fx-background-color: gray;");
        gladiatorView.getChildren().add(piece);
        return gladiatorView;
    }
}
