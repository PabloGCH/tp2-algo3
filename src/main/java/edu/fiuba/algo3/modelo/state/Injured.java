package edu.fiuba.algo3.modelo.state;

public class Injured implements State{
    public int move(){
        return 0;
    }

    public State update(){
        return new Active();
    }
}
