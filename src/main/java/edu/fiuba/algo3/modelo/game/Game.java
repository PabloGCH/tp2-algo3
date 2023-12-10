package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private final int MAX_TURNS_IN_A_GAME = 30, NEXT_GLADIATOR_TO_PLAY = 0;
    private int turn = 0;
    private int gladiatorTurn = 0;
    private ArrayList<Gladiator> gladiators = new ArrayList<>();
    private ArrayList<Square> path;
    private Dice dice;
    private static Game instance;
    private GameState state;

    private Game(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        this.path = path;
        this.gladiators = gladiators;
        this.dice = dice;
        this.turn = 0;
        this.state = new ActiveGame();
    }
    public static Game getInstance() {
        return instance;
    }
    public ArrayList<Square> getPath() {
        return this.path;
    }
    public static Game getInstance(ArrayList<Gladiator> gladiators, ArrayList<Square> path, Dice dice) {
        if (instance == null) {
            instance = new Game(gladiators, path, dice);
        }
        return instance;
    }
    // start game deberia dejar el juego listo para jugarse solamente.
    public String startGame() {
        this.state = new ActiveGame();
        this.state.entryOfTheGladiatorToTheFirstSquare(gladiators, path);
        Random random = new Random();
        String randomName = gladiators.get(random.nextInt(gladiators.size()) - 1).getName();
        while(gladiators.get(0).getName() != randomName){
            Gladiator aGladiator = gladiators.remove(0);
            gladiators.add(aGladiator);
        }
        return gladiators.get(0).getName();
    }
    
    //TODO hay que elegir una de las dos opciones.
    // play turn que debería realizarse un turno de un gladiador
    private void updateTurn(){
        gladiatorTurn = this.state.turnEnded(gladiatorTurn, this.gladiators);
        if (gladiatorTurn == this.gladiators.size()){
            turn++;
            gladiatorTurn = 0;
        }
        if (turn == MAX_TURNS_IN_A_GAME){ this.state = new FinishedByTurns(); }
    }

    public GameState playTurn(int diceResult){
        this.state = this.state.nextTurn(this.gladiators, this.path, diceResult);
        updateTurn();
        return this.state;
    }

    public ArrayList<Gladiator> getGladiators() {
        return gladiators;
    }
}

