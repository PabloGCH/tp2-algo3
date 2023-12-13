package edu.fiuba.algo3.modelo.game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game implements GameObservable {
    private final int MAX_TURNS_IN_A_GAME = 30, NEXT_GLADIATOR_TO_PLAY = 0;
    private int turn;
    private int gladiatorTurn = 0;
    private ArrayList<Gladiator> gladiators;
    private ArrayList<Square> path;
    private static Game instance;
    private GameState state;
    private ArrayList<GameObserver> observers;
    private Game(ArrayList<Gladiator> gladiators, ArrayList<Square> path) {
        this.path = path;
        this.gladiators = gladiators;
        this.turn = 0;
        this.state = new ActiveGame();
        this.observers = new ArrayList<>();
    }
    public void addEffectsObserver(EffectObserver observer) {
        for (Square square : path) {
            square.addEffectObserver(observer);
        }
    }
    public static Game getInstance() {
        return instance;
    }
    public ArrayList<Square> getPath() {
        return this.path;
    }
    public static Game getInstance(ArrayList<String> gladiatorsNames, ArrayList<Square> path) {
        if (instance == null) {
            ArrayList<Gladiator> gladiators = new ArrayList<>();
            for (String name : gladiatorsNames) {
                gladiators.add(new Gladiator(name));
            }
            instance = new Game(gladiators, path);
        }
        return instance;
    }
    public String startGame() {
        this.state = new ActiveGame();
        this.state.entryOfTheGladiatorToTheFirstSquare(gladiators, path);
        Random random = new Random();
        int randomResult = random.nextInt(gladiators.size());
        String randomName = gladiators.get(randomResult).getName();
        while(!Objects.equals(gladiators.get(0).getName(), randomName)){
            Gladiator aGladiator = gladiators.remove(0);
            gladiators.add(aGladiator);
        }
        return gladiators.get(0).getName();
    }
    public void restartGame() {
        instance = null;
    }
    public void restartGameWithSamePlayers() {
        ArrayList<Gladiator> newGladiators = new ArrayList<>();
        for (Gladiator gladiator : this.gladiators) {
            Gladiator aGladiator = new Gladiator(gladiator.getName());
            newGladiators.add(aGladiator);
        }
        this.gladiators = newGladiators;
        this.startGame();
    }
    private void updateTurn(){
        gladiatorTurn = this.state.turnEnded(gladiatorTurn, this.gladiators);
        if (gladiatorTurn == this.gladiators.size()){
            turn++;
            gladiatorTurn = 0;
        }
        if (turn == MAX_TURNS_IN_A_GAME){ this.state = this.state.defeat(); }
    }
    public GameState playTurn(int diceResult){
        this.state = this.state.nextTurn(this.gladiators, this.path, diceResult);
        updateTurn();
        this.updateObservers();
        return this.state;
    }
    public ArrayList<Gladiator> getGladiators() {
        return gladiators;
    }
    public void addObserver(GameObserver observer) {
        this.observers.add(observer);
        this.updateObserver(observer);
    }
    public void updateObservers() {
        for (GameObserver observer : observers) {
            this.updateObserver(observer);
        }
    }
    private void updateObserver(GameObserver observer) {
        String currentGladiator = this.gladiators.get(NEXT_GLADIATOR_TO_PLAY).getName();
        boolean canPlay = this.gladiators.get(NEXT_GLADIATOR_TO_PLAY).canPlay();
        observer.update(currentGladiator, canPlay, turn);
    }
}