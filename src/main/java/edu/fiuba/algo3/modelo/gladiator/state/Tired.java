package edu.fiuba.algo3.modelo.gladiator.state;

public class Tired extends State{
    private final int ACTIVE_GLADIATOR = 0, RECOVERED_ENERGY = 5;
    @Override
    public State update(int energy){
        if (energy > ACTIVE_GLADIATOR) {
            System.out.println("You recover energy");
            return new Active();
        }
        return this;
    }
    public String showState(){
        return "Tired";
    }
    @Override
    public int energyFromState(int energy) {
        System.out.println("You recover " + RECOVERED_ENERGY + " energy points");
        return (energy + RECOVERED_ENERGY);
    }
}