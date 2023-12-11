package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase03 {
    @Test
    public void test03APlayerCantMoveWithoutEnergy() {;
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        Square initialSquare = new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position);
        map.add(initialSquare);
        position = new Position(1,0,1);
        Square beastSquare = new Square(effectFactory.createEffect("Fiera"),effectFactory.createEffect("NullEffect"), position);
        map.add(beastSquare);
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add("Example");

        Game game = Game.getInstance();
        if(game != null){
            game.restartGame();
        }
        game = Game.getInstance(gladiatorsNames, map, new Dice());
        game.startGame();
        game.playTurn(1);
        game.playTurn(1);

        assertEquals(5, game.getGladiators().get(0).getEnergy());
        game.restartGame();
    }
}
