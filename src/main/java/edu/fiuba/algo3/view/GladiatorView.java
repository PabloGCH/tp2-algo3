package edu.fiuba.algo3.view;

import java.util.HashMap;
import edu.fiuba.algo3.modelo.gladiator.GladiatorObserver;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

public class GladiatorView implements GladiatorObserver {
    private Pane parentView;
    private final Pane viewRef;
    private final HashMap<String, Pane> gladiatorGrids;
    private static int colorCounter = 0;
    private Tooltip tooltip;
    public void update(int row, int column, int energy, String equipment, String name, String rank, String state) {
        Pane squareView = gladiatorGrids.get(row + "-" + column);
        if(parentView != null) parentView.getChildren().remove(viewRef);
        this.tooltip.setText(name);
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
        this.tooltip = new Tooltip();
        this.tooltip.setShowDelay(Duration.millis(100));
        Tooltip.install(piece, this.tooltip);
        if (colorCounter == 6) {
            colorCounter = 0;
        }
        return gladiatorView;
    }
}