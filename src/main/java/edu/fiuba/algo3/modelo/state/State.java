package edu.fiuba.algo3.modelo.state;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import edu.fiuba.algo3.modelo.squares.*;

public interface State {
    public int move(int diceResult);

    public State update(int energy);

    public void runEffect(Effect effect, Gladiator gladiator);

    public State fracture();
}
