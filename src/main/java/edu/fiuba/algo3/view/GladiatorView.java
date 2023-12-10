package edu.fiuba.algo3.view;


import java.util.HashMap;

import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class GladiatorView implements GladiatorObserver {
    private Pane parentView;
    private Pane viewRef;
    private HashMap<String, Pane> gladiatorGrids;
    private static int colorCounter = 0;

    public void update(int row, int column, int energy, String equipment, String name) {
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
        GladiatorView.colorCounter++;
        Pane gladiatorView = new Pane();
        Image gladiator = new Image(getClass().getResource("/img/gladiator" + GladiatorView.colorCounter + ".png").toExternalForm());
        ImageView piece = new ImageView();
        piece.setFitHeight(18);
        piece.setFitWidth(18);
        piece.setImage(gladiator);
        gladiatorView.getChildren().add(piece);
        return gladiatorView;
    }
}
