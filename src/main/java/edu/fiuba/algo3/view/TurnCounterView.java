package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.game.GameObserver;
import javafx.geometry.Pos;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class TurnCounterView implements GameObserver {
    private Text text;
    public TurnCounterView() {
        this.text = new Text();
        this.text.setFill(Color.WHITE);
    }
    public void update(String gladiatorName, boolean canPlay, int gameTurn) {
        this.text.setText("Current turn: " + gameTurn);
    }
    public Pane view() {
        FlowPane turnCounterView = new FlowPane();
        turnCounterView.setMouseTransparent(true);
        turnCounterView.getChildren().add(this.text);
        turnCounterView.setAlignment(Pos.BOTTOM_LEFT);
        turnCounterView.setStyle("-fx-padding: 10px;-fx-text-fill: white;");
        return turnCounterView;
    }
}