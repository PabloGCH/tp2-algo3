package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.energy.Energy;

public interface State {
    public int move();

    public State update(Energy energy);
}
