package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;

import java.util.ArrayList;


public class UseCase12 {
    @Test
    public void tetsGameEnds() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        boolean finish = false;
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(new Gladiator("Example"));
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Comida"), position));

        position = new Position(2,0,2);

        position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("Comida"),effectFactory.createEffect("NullEffect"), position));

        position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),new FinishLineEffect(), position));
        /*squareFactory = new FinishLineFactory();
        effectFactory = new FinishLineEffectFactory();
        map.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));*/

        //Game game = Game.getInstance(gladiators, map, new Dice());
        //finish = game.startGame();

        //assertFalse(finish); //TODO bucle
    }
}
