package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class UseCase02 {
    @Test
    public void test02ANewPlayersGladiatorStartsAtTheInitialSquare(){
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(3,0,3);
        map.add(new Square(effectFactory.createEffect("Bacanal"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createEffect("NullEffect"), new FinishLineEffect(), position));

        ArrayList<String> gladiatorsNames = new ArrayList<>();
        gladiatorsNames.add("Example");

        Game game = Game.getInstance(gladiatorsNames, map);
        game.startGame();
        Assertions.assertEquals(35, game.getGladiators().get(0).getEnergy());
        game.restartGame();
    }
}
