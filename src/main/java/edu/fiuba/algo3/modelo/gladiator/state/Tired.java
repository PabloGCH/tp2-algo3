package edu.fiuba.algo3.modelo.gladiator.state;

public class Tired extends State{
    @Override
    public State update(int energy){
        if (energy > 0) {
            return new Active();
        }
        return this;
    }
    public String showState(){
        return "Tired";
    }
    @Override
    public int energyFromState(int energy) {
        return (energy + 5);
    }
}