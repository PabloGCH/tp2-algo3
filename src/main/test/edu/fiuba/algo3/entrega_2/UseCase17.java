package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class UseCase17 {
    @Test
    public void test17AMapIsBuiltCorrectlyBasedOnJSONFile() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Square> path;
        MapFacade facade = new MapFacade();
        Gladiator aGladiator = new Gladiator("Example");
        int expectedInitialEnergy = 0;
        int expectedSecondEnergy = 20;
        int expectedThirdEnergy = 35;

        path = facade.loadMap();
        assertEquals(expectedInitialEnergy, aGladiator.getEnergy());
        path.get(0).affect(aGladiator);
        assertEquals(expectedSecondEnergy, aGladiator.getEnergy());

        path.get(2).affect(aGladiator);

        assertEquals(expectedThirdEnergy, aGladiator.getEnergy());
    }
}
