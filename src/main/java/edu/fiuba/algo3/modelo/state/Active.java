package edu.fiuba.algo3.modelo.state;

public class Active implements State{
    public int move(){
        return 1;
    }
    public State update(){
        return this;
    }
}
