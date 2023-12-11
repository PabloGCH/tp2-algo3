package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.game.GameState;

public class DiceButtonController {
    private Game game;
    private Dice dice;

    public DiceButtonController() {
        game = Game.getInstance();
        dice = new Dice();
    }

    public void throwDice() {
        int diceResult = dice.throwDice();
        GameState gameState = game.playTurn(1);
        gameState.updateScreen();
    }
}

