package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class Active extends State{
    private final int ENERGY_LIMIT = 0;
    @Override
    public int move(int diceResult){
        return diceResult;
    }
    @Override
    public State update(int energy){
        if (energy <= ENERGY_LIMIT) {
            System.out.println("Are you tired");
            return new Tired();
        }
        return this;
    }
    @Override
    public void runEffect(Effect effect, Gladiator gladiator){
        effect.affect(gladiator);
    }
    @Override
    public State fracture(){
        System.out.println("you were injured");
        return (new Injured());
    }
    @Override
    public State getIntoBacchanalia(Gladiator aGladiator) {
        System.out.println("You entered a Bacchanal");
        return new InTheBacchanalia(aGladiator);
    }
    @Override
    public boolean canPlay() {
        return true;
    }
}