package edu.fiuba.algo3.unittests.mapParserTest;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class mapParserTest {
    @Test
    public void validateJSONExistsTest() {
        assertThrows(MapFileNotFound.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/nonExistentFile.json",
                    "nonExistentFile.json"
            );
        });
    }
    @Test
    public void validateJSONHasWrongSyntax() {
        assertThrows(MapFileCouldNotBeParsed.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/mapTestInvalidJsonSyntax.json",
                    "mapTestInvalidJsonSyntax.json"
            );
        });
    }
    @Test
    public void validateJSONIsHasWrongKeys() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/mapTestInvalidKeysInJson.json",
                    "mapTestInvalidKeysInJson.json"
            );
        });
    }
    @Test
    public void validateJSONMapWithoutCaminoThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/mapWithoutCamino.json",
                    "mapWithoutCamino.json"
            );
        });
    }
    @Test
    public void validateJSONMapWithoutCeldasThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/mapWithoutCeldas.json",
                    "mapWithoutCeldas.json"
            );
        });
    }
    @Test
    public void validateJSONFileJSONArrayThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/JSONArray.json",
                    "NotJSONArray.json"
            );
        });
    }
    @Test
    public void validateJSONWithWrongCoordinateThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapParser = new MapJsonParser();
            mapParser.loadMap(
                    "src/main/resources/files/mapWithWrongCoordinates.json",
                    "mapWithWrongCoordinates.json"
            );
        });
    }
    @Test
    public void validateFoodSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(2);
        square.affect(gladiator);
        int energyPoints = gladiator.getEnergy();
        assertEquals(35, energyPoints);
    }

    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(0);
        square.affect(gladiator);
        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);

        square = path.get(1);
        square.affect(gladiator);

        gladiator.fightWithBeast();
        energyPoints = gladiator.getEnergy();
        assertEquals(5, energyPoints);
    }

    @Test
    public void validateBeastSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(0);
        square.affect(gladiator);
        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);

        square = path.get(4);
        square.affect(gladiator);

        energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints);
    }

    @Test
    public void validateWineSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");
        int energyLostInBacchanaliaWithDiceResultOne = 4;

        Square square = path.get(0);
        square.affect(gladiator);
        int initialEnergy = gladiator.getEnergy();
        assertEquals(20, initialEnergy);

        square = path.get(5);
        square.affect(gladiator);
        gladiator.move(path.size(),1);

        int finalEnergy = gladiator.getEnergy();
        assertEquals(initialEnergy - energyLostInBacchanaliaWithDiceResultOne, finalEnergy);
    }

    @Test
    public void validateInjurySquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {

        var mapParser = new MapJsonParser();
        ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
        );
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(3);
        square.affect(gladiator);

        int currentPathPosition = 3;
        int newPathPosition = gladiator.move(path.size(), 1);
        assertEquals(currentPathPosition,newPathPosition);
    }

}
