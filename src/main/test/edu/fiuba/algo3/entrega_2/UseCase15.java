package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UseCase15 {

    @Test
    public void validateBeastSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {

        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");
        Square square = path.get(4);
        int initialEnergy = gladiator.getEnergy();

        assertEquals(20, initialEnergy);
        square.affect(gladiator);
        int finalEnergy = gladiator.getEnergy();
        assertEquals(initialEnergy - 20, finalEnergy);
    }
}
