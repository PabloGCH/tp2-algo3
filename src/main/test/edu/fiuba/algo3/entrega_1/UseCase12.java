package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.game.GameState;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class UseCase12 {
    @Test
    public void testGameEnds(){
        Dice dice = new Dice();
        GameState gameState;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));


        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add(gladiators.get(0).getName());

        Game game = Game.getInstance();
        game = Game.getInstance(gladiatorsNames, map, dice);
        game.startGame();
        gameState = game.playTurn(dice.throwDice());
        while (!gameState.Finalized()){
            gameState = game.playTurn(dice.throwDice());
        }

        Assertions.assertFalse(gameState.result(gladiators));
        game.restartGame();
    }
}
