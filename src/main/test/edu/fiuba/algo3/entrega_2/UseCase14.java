package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;

public class UseCase14 {
    @Test
    public void validateFoodSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator("Example");
            //ArrayList<Position> path = map.getPath();

            Square square = path.get(2);
            square.affect(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(15, energyPoints);
    }

    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
            var mapParser = new MapJsonParser();
            ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            //ArrayList<Position> path = map.getPath();
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
            //ArrayList<Position> path = map.getPath();
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
            //ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator("Example");

            Square square = path.get(0);
            square.affect(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            square = path.get(5);
            square.affect(gladiator);

            energyPoints = gladiator.getEnergy();
            assertTrue(energyPoints < 20);
    }

    @Test
    public void validateInjurySquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {

            var mapParser = new MapJsonParser();
            ArrayList<Square> path = mapParser.loadMap(
                "src/main/resources/files/map.json",
                "mapTest.json"
            );
            //ArrayList<Position> path = map.getPath();
            Gladiator gladiator = new Gladiator("Example");

            Square square = path.get(0);
            square.affect(gladiator);
            int energyPoints = gladiator.getEnergy();
            assertEquals(20, energyPoints);

            square = path.get(3);
            square.affect(gladiator);

            energyPoints = gladiator.getEnergy();
            assertTrue(energyPoints < 20);
    }
}
