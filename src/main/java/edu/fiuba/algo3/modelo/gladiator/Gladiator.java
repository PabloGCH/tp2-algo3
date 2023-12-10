package edu.fiuba.algo3.modelo.gladiator;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.equipment.Equipment;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.gladiator.state.*;
import edu.fiuba.algo3.modelo.gladiator.rank.Rank;
import edu.fiuba.algo3.modelo.gladiator.rank.Rookie;
import edu.fiuba.algo3.modelo.gladiator.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.squares.*;
import javafx.geometry.Dimension2D;
import javafx.scene.image.ImageView;

public class Gladiator implements GladiatorObservable {
    private static final int ENERGY_FROM_FOOD = 15, ENERGY_LOST_FOR_EACH_CUP = 4, INITIAL_ENERGY = 20;
    private String name;
    private State state;
    private int energy;
    private Equipment equipment;
    private Rank rank;
    private ArrayList<GladiatorObserver> observers;
    public Position position;

    public Gladiator(String name) {
        this.name = name;
        this.energy = INITIAL_ENERGY;
        this.equipment = new NullEquipment();
        this.rank = new Rookie();
        this.state = new Active();
        this.position = new Position(0,0,0);
        this.observers = new ArrayList<>();
    }
    public void drinkWine(int cupsOfWineAmount) {
        this.energy = this.energy - ENERGY_LOST_FOR_EACH_CUP * cupsOfWineAmount;
    }

    private void update(){
        this.rank = this.rank.ascent();
        this.energy = this.rank.energyFromExperience(this.energy);
    }

    public void eat() {
        this.energy += ENERGY_FROM_FOOD;
    }

    public void fightWithBeast() {
        this.energy = this.equipment.receiveAttack(this.energy);
        refreshState();
    }

    public int getEnergy() {
        return this.energy;
    }

    public void upgrade(){
        this.equipment = this.equipment.upgrade();
    }

    public void injured(){
        this.state = this.state.fracture();
    }

    public int move(int sizePath, int diceResult) {
        this.update();
        int steps = this.state.move(diceResult);
        return this.position.moveFoward(steps, sizePath);
    }
    public String getName(){
        return this.name;
    }

    public void runEffect(Effect effect){
        this.state.runEffect(effect, this);
    }
    public void runEffect(Bacchanalia effect){
        this.state.runEffect(effect, this);
    }
    public void positionate(Position position){
        this.position = position;
        this.updateObservers();
    }

    public void getIntoBacchanalia() {
        this.state = this.state.getIntoBacchanalia(this);
    }
    public void refreshState() {
        this.state = this.state.update(this.energy);
    }
    public void tryToWin(Position middlePosition) {
        this.state = this.equipment.win(this.state);
        this.state.tryToWin(this, middlePosition);
    }
    public GameState won() {
        return this.state.isWinner();
    }

    public void decideIfPlaysAgain(TurnDecider turnDecider) {
        this.state.decideIfPlaysAgain(turnDecider);
    }

    public int turnEnded(int gladiatorTurn){
        return this.state.updateTurn(gladiatorTurn);
    }
    

    public void addObserver(GladiatorObserver observer) {
        observers.add(observer);
    }

    private void updateObservers() {
        for (GladiatorObserver observer : observers) {
            Dimension2D gladiatorPosition = this.position.coordinates();
            int row = (int) gladiatorPosition.getWidth() - 1;
            int column = (int) gladiatorPosition.getHeight() - 1;
            int energy = this.energy;
            observer.update(row, column, energy);
        }
    }

    public String showEquipment(){
        return this.equipment.showImage();
    }
}
