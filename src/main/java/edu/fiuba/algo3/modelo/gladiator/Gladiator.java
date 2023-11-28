package edu.fiuba.algo3.modelo.gladiator;
import edu.fiuba.algo3.modelo.equipment.Equipment;
import edu.fiuba.algo3.modelo.energy.Energy;
import edu.fiuba.algo3.modelo.equipment.Key;
import edu.fiuba.algo3.modelo.rank.Rank;
import edu.fiuba.algo3.modelo.rank.Rookie;
import edu.fiuba.algo3.modelo.equipment.NullEquipment;
import edu.fiuba.algo3.modelo.state.Injured;
import edu.fiuba.algo3.modelo.state.State;
import edu.fiuba.algo3.modelo.state.Tired;
import edu.fiuba.algo3.modelo.Config;
import edu.fiuba.algo3.modelo.squares.NullPosition;
import edu.fiuba.algo3.modelo.squares.Position;

public class Gladiator {
    private String name;
    private State state;
    private Energy energy;
    private Equipment equipment;
    private Rank rank;
    private Position position;
    private int worthy = Config.UNABLE_TO_WIN.getValue();//Worthy enough to reach Pompeya and win the game

    public Gladiator() {
        this.energy = new Energy(0);
        this.equipment = new NullEquipment();
        this.rank = new Rookie();
        this.state = new Tired();
        this.position = new NullPosition();
    }
    
    public void turn() {;
        update();
        this.state = this.state.update(this.energy);
        int distanceToMove = this.state.move();
        this.move(distanceToMove);
    }
    
    public void drinkWine(int cupsOfWineAmount) {
        int energyLostForEachCup = Config.ENERGY_LOST_FOR_EACH_CUP_OF_WINE.getValue();
        this.energy = this.energy.substract(new Energy(energyLostForEachCup * cupsOfWineAmount));
    }

    private void update(){
        this.rank = this.rank.ascent();
        this.energy = this.rank.energyFromExperience(this.energy);
    }

    public void eat() {
        this.energy = this.energy.add(new Energy(15));
    }

    public void fightWithBeast() {
        this.energy = this.equipment.receiveAttack(this.energy);
    }

    public int getEnergy() {
        return this.energy.getPoints();
    }
    public Equipment getEquipment() {
        return this.equipment;
    }
    public void setInitialEnergy(Energy energy) {
        this.energy = this.energy.add(energy);
    }

    public void upgrade(){
        this.equipment = this.equipment.upgrade();
    }

    public void injured(){
        this.state = new Injured();
    }

    public void worthy(){//Only used by "FinishLineEffect", if a player reach the finish line without the key --> worthy == false.
        if(equipment.worthy()){
            worthy = Config.ABLE_TO_WIN.getValue();
        }
        else{
            worthy = Config.UNABLE_TO_WIN_ON_FINISH_LINE.getValue();
        }
    }

    public int candidateToWin(){
        return worthy;
    }
    public void move(int distance) {
        Position newPosition = this.position;
        for(int i = 0; i < distance; i++) {
            newPosition = newPosition.next();
        }
        this.position.removePiece(this);
        this.position = newPosition;
        this.position.receivePiece(this);
    }
    public void notWorthy(){
        worthy = Config.UNABLE_TO_WIN.getValue();
    }
}
