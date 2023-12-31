package edu.fiuba.algo3.modelo.gladiator.state;

public class Injured extends State{
    private int shift;
    private final int TURNS_TO_BE_INJURED = 1;

    public Injured(){
        this.shift = 0;
    }
    @Override
    public State update(int energy){
        if (shift == TURNS_TO_BE_INJURED) {
            System.out.println("Recovered from injury");
            return new Active();
        }
        shift++;
        return this;
    }
    public String showState(){
        return "Injured";
    }
}