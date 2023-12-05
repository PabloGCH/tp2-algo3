package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.game.TurnDecider;
import edu.fiuba.algo3.modelo.gladiator.equipment.Equipment;
import edu.fiuba.algo3.modelo.gladiator.state.Active;
import edu.fiuba.algo3.modelo.gladiator.state.State;
import edu.fiuba.algo3.modelo.gladiator.rank.Rank;
import edu.fiuba.algo3.modelo.gladiator.rank.Rookie;
import edu.fiuba.algo3.modelo.gladiator.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.squares.*;

public class Gladiator {
    private static final int ENERGY_FROM_FOOD = 15, ENERGY_LOST_FOR_EACH_CUP = 4, INITIAL_ENERGY = 20;
    private String name;
    private State state;
    private int energy;
    private Equipment equipment;
    private Rank rank;
    public Position position;

    public Gladiator(String name) {
        this.name = name;
        this.energy = INITIAL_ENERGY;
        this.equipment = new NullEquipment();
        this.rank = new Rookie();
        this.state = new Active();
        this.position = new Position(0,0,0);//TODO change this
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
    public boolean completeArmament() {
        return this.equipment.complete();
    }
    public void setInitialEnergy(int energy) {
        this.energy = (this.energy + 20);
    }

    public void upgrade(){
        this.equipment = this.equipment.upgrade();
    }

    public void injured(){
        this.state = this.state.fracture();
    }

    public int move(int sizePath, int diceResult) {
        update();
        int steps = this.state.move(diceResult);
        return this.position.moveFoward(steps, sizePath);
    }
    public String getName(){
        return this.name;
    }

    public void runEffect(Effect effect){
        this.state.runEffect(effect, this);
    }
    public void positionate(Position position){
        this.position = position;
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
}
