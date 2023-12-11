package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UseCase03 {
    @Test
    public void test03APlayerCantMoveWithoutEnergy() {;
        Dice dice = new Dice();
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("Fiera"),effectFactory.createEffect("NullEffect"), position));
        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add("Example");

        Game game = Game.getInstance();
        if(game != null){
            game.restartGame();
        }
        game = Game.getInstance(gladiatorsNames, map, dice);
        game.startGame();
        game.playTurn(dice.throwDice());
        //aGladiator.fightWithBeast();
        int initialPositionInPath = 0;
        int newPositionInPath = game.getGladiators().get(0).move(map.size(), 1);

        Assertions.assertEquals(initialPositionInPath, newPositionInPath);
        Assertions.assertEquals(0, game.getGladiators().get(0).getEnergy());
    }
}
