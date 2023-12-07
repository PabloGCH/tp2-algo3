package edu.fiuba.algo3.modelo.squares;

import edu.fiuba.algo3.modelo.Position;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;

public class Square{
    private Position position;
    protected Effect prize;
    protected Effect obstacle;

    public Square(Effect obstacle, Effect prize, Position aPosition) {
        this.prize = prize;
        this.obstacle = obstacle;
        this.position = aPosition;
    }

    public void affect(Gladiator gladiator){
        gladiator.positionate(position);
        gladiator.runEffect(obstacle);
        gladiator.runEffect(prize);
    }

    public Position getPosition() {
        return this.position;
    }
}
