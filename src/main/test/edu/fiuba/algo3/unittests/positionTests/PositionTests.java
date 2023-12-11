package edu.fiuba.algo3.unittests.positionTests;

import edu.fiuba.algo3.modelo.position.Position;
import javafx.geometry.Dimension2D;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PositionTests {
    @Test
    public void test01ComparePositionReturnsTrueIfPositionsEqual(){
        Position positionOne = new Position(0,0,0);
        Position positionTwo = new Position(0,0,0);

        assertTrue(positionOne.comparePosition(positionTwo));
    }
    @Test
    public void test02ComparePositionReturnsFalseIfPositionsNotEqual(){
        Position positionOne = new Position(0,0,0);
        Position positionTwo = new Position(1,1,1);

        assertFalse(positionOne.comparePosition(positionTwo));
    }
    @Test
    public void test03MoveForwardReturnsNewPathLocationIfNotCrossPathBoundaries(){
        Position position = new Position(0,0,3);
        int newLocation = position.moveFoward(1,10);
        assertEquals(4, newLocation);
    }
    @Test
    public void test04MoveForwardReturnsLastPathLocationIfCrossPathBoundaries(){
        Position position = new Position(0,0,7);
        int newLocation = position.moveFoward(6,10);
        assertEquals(9, newLocation);
    }
    @Test
    public void test05CoordinatesReturnsCorrectCoordinates(){
        Position position = new Position(7,9,0);
        Dimension2D coordinates = position.coordinates();
        assertEquals(7,coordinates.getWidth());
        assertEquals(9, coordinates.getHeight());
    }
}
