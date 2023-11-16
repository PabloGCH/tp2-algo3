package edu.fiuba.algo3.modelo.state;

public interface State {
    public int move();

    public State update();
}
