package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.game.Game;

public class DiceButtonController {
    private Game game;
    private Dice dice;

    DiceButtonController() {
        game = Game.getInstance();
        dice = new Dice();
    }

    public void throwDice() {
        int diceResult = dice.throwDice();
        game.playTurn(diceResult);
    }
}
