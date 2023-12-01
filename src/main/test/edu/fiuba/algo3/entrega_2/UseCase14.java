package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Position;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase14 {
    @Test
    public void validateFoodSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            Map map = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator();
            ArrayList<Position> path = map.getPath();

            Position position = path.get(2);
            position.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(15, energyPoints);
    }

    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            Map map = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator();

            Position position = path.get(0);
            position.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            position = path.get(1);
            position.receivePiece(gladiator);

            gladiator.fightWithBeast();
            energyPoints = gladiator.getEnergy();
            assertEquals(5, energyPoints);
    }

    @Test
    public void validateBeastSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            Map map = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator();

            Position position = path.get(0);
            position.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            position = path.get(4);
            position.receivePiece(gladiator);

            energyPoints = gladiator.getEnergy();
            assertEquals(0, energyPoints);
    }

    @Test
    public void validateWineSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            Map map = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator();

            Position position = path.get(0);
            position.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            position = path.get(5);
            position.receivePiece(gladiator);

            energyPoints = gladiator.getEnergy();
            assertTrue(energyPoints < 20);
    }

    @Test
    public void validateInjurySquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {

            var mapParser = new MapJsonParser();
            var map = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator();

            Position position = path.get(0);
            position.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            position = path.get(3);
            position.receivePiece(gladiator);

            energyPoints = gladiator.getEnergy();
            assertTrue(energyPoints < 20);
    }
}
