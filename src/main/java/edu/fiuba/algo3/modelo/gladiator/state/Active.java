package edu.fiuba.algo3.modelo.gladiator.state;

import edu.fiuba.algo3.modelo.squares.*;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;


public class Active extends State{
    @Override
    public int move(int diceResult){
        return diceResult;
    }
    @Override
    public State update(int energy){
        if (energy <= 0) {
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
        return (new Injured());
    }
    @Override
    public State getIntoBacchanalia(Gladiator aGladiator) {
        return new InTheBacchanalia(aGladiator);
    };
}
