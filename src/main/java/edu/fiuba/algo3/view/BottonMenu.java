package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.DiceButtonController;
import edu.fiuba.algo3.modelo.game.GameObserver;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Button diceButton;
    private boolean canPlay;
    private ImageView dice = new ImageView();
    private HashMap<String, Image> dicesImages = new HashMap<>();

    CountDownLatch latch = new CountDownLatch(1);

    public void updateGladiator(String currentPlayerName, boolean canPlay) {
        this.name.setText(currentPlayerName);
        this.canPlay = canPlay;
        if(canPlay) this.diceButton.setText("Throw the dice");
        else this.diceButton.setText("Skip turn");
    }

    public void updateDiceResult(int lastDiceValue) {
        if(lastDiceValue != 0) this.lastDiceValue.setText("Last dice result: " + lastDiceValue);
    }

    public BottonMenu() {
        this.canPlay = true;
        this.name = new Text("");
        this.lastDiceValue = new Text("Last dice throw result: ");
        this.name.setFill(Color.WHITE);
        this.lastDiceValue.setFill(Color.WHITE);
        this.dice.setFitWidth(50);
        this.dice.setFitHeight(50);
        this.diceButton = new Button("Throw the dice");

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
        
        diceButton.setOnAction(e ->{
            diceButton.setDisable(true);
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event ->{
                if(!canPlay) return;
                dice.setImage(dicesImages.get(String.valueOf(new Random().nextInt(5) + 1)));
            }));
            timeline.setCycleCount(15);
            timeline.setOnFinished(event -> {
                if(canPlay) diceButtonController.throwDice(this.dice, this.dicesImages);
                else diceButtonController.skipTurn();
                diceButton.setDisable(false);
            });
            timeline.play();
        });



        bottomMenu.getStyleClass().add("bottom-menu");
        diceButton.getStyleClass().add("dice-button");

        bottomMenu.getChildren().add(this.name);
        bottomMenu.getChildren().add(diceButton);
        bottomMenu.getChildren().add(this.dice);

        bottomMenu.setAlignment(Pos.CENTER);
        bottomMenu.setSpacing(8);

        bottomMenu.setMinHeight(130);

        return bottomMenu;
    }
}
