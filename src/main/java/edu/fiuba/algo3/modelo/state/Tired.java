package edu.fiuba.algo3.modelo.state;

public class Tired implements State{
    public int move(){
        return 0;
    }
    public State update(){
        //TODO implement when energy > 0
        return new Active();
    }
}
