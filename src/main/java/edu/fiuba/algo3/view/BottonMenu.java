package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.DiceButtonController;
import edu.fiuba.algo3.modelo.game.GameObserver;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class BottonMenu implements GameObserver {
    private Text name;
    private Text lastDiceValue;

    public void updateGladiatorName(String currentPlayerName) {
        this.name.setText(currentPlayerName);
    }

    public void updateDiceResult(int lastDiceValue) {
        if(lastDiceValue != 0) this.lastDiceValue.setText("Last dice result: " + lastDiceValue);
    }

    public BottonMenu() {
        this.name = new Text("");
        this.lastDiceValue = new Text("Last dice throw result: ");
        this.name.setFill(Color.WHITE);
        this.lastDiceValue.setFill(Color.WHITE);
    }

    public Pane view() {
        DiceButtonController diceButtonController = new DiceButtonController();
        VBox bottomMenu = new VBox();
        
        Button diceButton = new Button("Throw the dice");
        diceButton.setOnAction(e ->{diceButtonController.throwDice();});

        bottomMenu.getStyleClass().add("bottom-menu");
        diceButton.getStyleClass().add("dice-button");

        bottomMenu.getChildren().add(this.name);
        bottomMenu.getChildren().add(diceButton);
        bottomMenu.getChildren().add(this.lastDiceValue);

        bottomMenu.setPrefHeight(90);
        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setSpacing(8);
        return bottomMenu;
    }
}
