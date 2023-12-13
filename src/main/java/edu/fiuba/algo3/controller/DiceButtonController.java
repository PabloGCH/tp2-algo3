package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.game.GameState;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.HashMap;

public class DiceButtonController {
    private Game game;
    private Dice dice;
    public DiceButtonController() {
        game = Game.getInstance();
        dice = new Dice();
    }
    public void throwDice(ImageView diceImageView, HashMap diceImages) {
        int diceResult = dice.throwDice();
        diceImageView.setImage((Image) diceImages.get(String.valueOf(diceResult)));
        GameState gameState = game.playTurn(diceResult);
        gameState.updateScreen(GameStateController.getInstance());
    }
    public void skipTurn() {
        GameState gameState = game.playTurn(0);
        gameState.updateScreen(GameStateController.getInstance());
    }
}