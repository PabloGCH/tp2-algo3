package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.EffectFactory;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class UseCase02 {
    @Test
    public void test02ANewPlayersGladiatorStartsAtTheInitialSquare() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        Gladiator aGladiator = new Gladiator("Example");
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*SquareFactory squareFactory = new InitialFactory();
        EffectFactory nullEffectFactory = new NullEffectFactory();
        EffectFactory effectFactory = new InitialEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
        */
        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("Comida"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createSquare("NullEffect"),effectFactory.createSquare("NullEffect"), position));
        /*
        squareFactory = new MiddleFactory();
        effectFactory = new FoodFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), nullEffectFactory.createEffect()));
        */
        position = new Position(3,0,3);
        map.add(new Square(effectFactory.createSquare("Bacanal"),effectFactory.createSquare("NullEffect"), position));
        /*
        effectFactory = new BacchanaliaFactory();
        map.add(squareFactory.createSquare(effectFactory.createEffect(), nullEffectFactory.createEffect()));
        */
        position = new Position(4,0,4);
        map.add(new Square(effectFactory.createSquare("NullEffect"), new FinishLineEffect(), position));
        /*
        squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(), effectFactory.createEffect()));
        */
        gladiators.add(aGladiator);
        Dice dice = new Dice();
        Game aGame = Game.getInstance(gladiators, map, dice);
        Assertions.assertEquals(aGladiator.getEnergy(), 20);
    }
}
