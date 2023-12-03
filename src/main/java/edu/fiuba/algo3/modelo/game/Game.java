package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

import java.util.ArrayList;

public class Game {
    private final int MAX_TURNS_IN_A_GAME = 30, NEXT_GLADIATOR_TO_PLAY = 0;
    private int turns = 0;
    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Square> path;
    private Dice dice;
    private boolean winner;
    private static Game instance;
    private GameState state;

    private Game(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        this.winner = false;
        this.path = path;
        this.gladiators = gladiators;
        this.dice = dice;
    }
    public static Game getInstance(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        if (instance == null) {
            instance = new Game(gladiators, path, dice);
        }
        return instance;
    }
    public boolean startGame() {
        boolean gameOver = false;
        this.state = new ActiveGame();
        while (!gameOver) {
        }
        return true;

    }

    public boolean result(int player) {
        if (this.winner) {
            System.out.println("Felicidades " + gladiators.get(player).getName() + "ganaste la partida");
            return true;
        }

        System.out.println("No hubo ganadores, suerte la proxima vez");
        return false;
    }

    private boolean gladiatorTurn(int diceResult) {
        this.state = this.state.nextTurn(gladiators, path, diceResult);
        return false;
    }
}