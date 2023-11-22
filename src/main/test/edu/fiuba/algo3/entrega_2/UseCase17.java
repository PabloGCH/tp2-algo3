package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class UseCase17 {
    @Test
    public void test17AMapIsBuiltCorrectlyBasedOnJSONFile() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<Square> map;
        MapFacade facade = new MapFacade();
        Gladiator aGladiator = new Gladiator();
        int expectedInitialEnergy = 0;
        int expectedSecondEnergy = 20;
        int expectedThirdEnergy = 0;

        map = facade.loadMap();
        assertEquals(expectedInitialEnergy, aGladiator.getEnergy().getPoints());
        map.get(0).receiveGladiator(aGladiator);
        assertEquals(expectedSecondEnergy, aGladiator.getEnergy().getPoints());

        map.get(0).unsetGladiator(aGladiator);
        map.get(1).receiveGladiator(aGladiator);

        assertEquals(expectedInitialEnergy, aGladiator.getEnergy().getPoints());
    }
}
