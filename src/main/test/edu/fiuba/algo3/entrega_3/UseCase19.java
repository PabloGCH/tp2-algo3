package edu.fiuba.algo3.entrega_3;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Dice;
import edu.fiuba.algo3.modelo.factories.*;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.game.Game;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.squares.*;

public class UseCase19 {
    @Test
    public void testPlayerWin() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        boolean finish = false;
        Gladiator gladiator1 = new Gladiator("Example");
        gladiator1.upgrade();
        gladiator1.upgrade();
        gladiator1.upgrade();
        gladiator1.upgrade();
        //gladiator1.result();
        ArrayList<Gladiator> gladiators = new ArrayList<>();
        gladiators.add(gladiator1);
        ArrayList<Square> map = new ArrayList<>();
        EffectFactory effectFactory = new EffectFactory();
        Position position = new Position(0,0,0);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("NullEffect"), position));
        //ArrayList<Position> path = new ArrayList<>();
        //SquareFactory squareFactory = new InitialFactory();
        //EffectFactory nullEffectFactory = new NullEffectFactory();
        //EffectFactory effectFactory = new InitialEffectFactory();
        //path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));

        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Equipamiento"), position));
        position = new Position(2,0,2);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Equipamiento"), position));
        position = new Position(3,0,3);
        map.add(new Square(effectFactory.createEffect("NullEffect"),effectFactory.createEffect("Equipamiento"), position));
        //squareFactory = new MiddleFactory();
        //effectFactory = new UpgradeFactory();
        //path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        //path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        //path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        position = new Position(1,0,1);
        map.add(new Square(effectFactory.createEffect("NullEquipment"),new FinishLineEffect(), position));
        //squareFactory = new FinishLineFactory();
        //effectFactory = new FinishLineEffectFactory();
        //path.add(squareFactory.createSquare(nullEffectFactory.createEffect(),effectFactory.createEffect()));
        Game game = Game.getInstance(gladiators, map, new Dice());

        finish = game.startGame();

        assertTrue(finish);
    }
}
