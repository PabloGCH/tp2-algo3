package edu.fiuba.algo3.unittests.mapFacadeTests;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.position.Position;
import edu.fiuba.algo3.modelo.squares.Square;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapFacadeTest {
    ArrayList<Square> path;
    @BeforeEach
    void setUp() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        MapFacade mapFacade = new MapFacade();
         path = mapFacade.loadMap();
    }

    @Test
    public void validateFoodSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(2);
        square.affect(gladiator);
        int energyPoints = gladiator.getEnergy();
        assertEquals(35, energyPoints);
    }

    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Gladiator gladiator = new Gladiator("Example");

        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);

        Square square = path.get(1);
        square.affect(gladiator);

        gladiator.fightWithBeast();
        energyPoints = gladiator.getEnergy();
        assertEquals(5, energyPoints);
    }

    @Test
    public void validateBeastSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Gladiator gladiator = new Gladiator("Example");

        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);

        Square square = path.get(4);
        square.affect(gladiator);

        energyPoints = gladiator.getEnergy();
        assertEquals(0, energyPoints);
    }

    @Test
    public void validateWineSquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Gladiator gladiator = new Gladiator("Example");
        int initialEnergy = 20;
        int energyLostInBacchanaliaWithDiceResultOne = 1 * 4;

        int energyPoints = gladiator.getEnergy();
        assertEquals(20, energyPoints);

        Square square = path.get(5);
        square.affect(gladiator);
        gladiator.move(path.size(),1);

        energyPoints = gladiator.getEnergy();
        assertEquals(initialEnergy - energyLostInBacchanaliaWithDiceResultOne, energyPoints);
    }

    @Test
    public void validateInjurySquareCreationFromMapJson() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Gladiator gladiator = new Gladiator("Example");

        Square square = path.get(3);
        square.affect(gladiator);

        int currentPathPosition = 3;
        int newPathPosition = gladiator.move(path.size(), 1);
        assertEquals(currentPathPosition,newPathPosition);
    }
    @Test
    public void validateInitialSquarePosition() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Position initialPosition = path.get(0).getPosition();
        Position expectedPosition = new Position(1, 7, 0);
        assertTrue(initialPosition.comparePosition(expectedPosition));
    }
    @Test
    public void validateFinalSquarePosition() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        Position finalPosition = path.get(path.size()-1).getPosition();
        Position expectedPosition = new Position(17, 1, path.size()-1);
        assertTrue(finalPosition.comparePosition(expectedPosition));
    }
}
