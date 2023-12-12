package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.DiceButtonController;
import edu.fiuba.algo3.modelo.game.GameObserver;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class BottonMenu implements GameObserver {
    private Text name;
    private Text lastDiceValue;
    private ImageView dice = new ImageView();
    private HashMap<String, Image> dicesImages = new HashMap<>();
    CountDownLatch latch = new CountDownLatch(1);

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
        this.dice.setFitWidth(50);
        this.dice.setFitHeight(50);

        this.dicesImages.put("1", new Image(getClass().getResource("/img/dice/dice1.png").toExternalForm()));
        this.dicesImages.put("2", new Image(getClass().getResource("/img/dice/dice2.png").toExternalForm()));
        this.dicesImages.put("3", new Image(getClass().getResource("/img/dice/dice3.png").toExternalForm()));
        this.dicesImages.put("4", new Image(getClass().getResource("/img/dice/dice4.png").toExternalForm()));
        this.dicesImages.put("5", new Image(getClass().getResource("/img/dice/dice5.png").toExternalForm()));
        this.dicesImages.put("6", new Image(getClass().getResource("/img/dice/dice6.png").toExternalForm()));

        this.dice.setImage(dicesImages.get("1"));
    }

    public Pane view() {
        DiceButtonController diceButtonController = new DiceButtonController();
        VBox bottomMenu = new VBox();
        
        Button diceButton = new Button("Throw the dice");
        diceButton.setOnAction(e ->{
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event ->{
                dice.setImage(dicesImages.get(String.valueOf(new Random().nextInt(5) + 1)));
            }));
            timeline.setCycleCount(15);
            timeline.setOnFinished(event -> diceButtonController.throwDice(this.dice, this.dicesImages));
            timeline.play();
        });

        bottomMenu.getStyleClass().add("bottom-menu");
        diceButton.getStyleClass().add("dice-button");

        bottomMenu.getChildren().add(this.name);
        bottomMenu.getChildren().add(diceButton);
        bottomMenu.getChildren().add(this.dice);

        bottomMenu.setPrefHeight(90);
        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setSpacing(8);
        return bottomMenu;
    }
}
