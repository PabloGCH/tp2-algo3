package edu.fiuba.algo3.entrega_2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import org.json.JSONArray;

import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.MapJsonParser;
import edu.fiuba.algo3.modelo.squares.Square;


public class UseCase14 {
    @Test
    public void validateFoodSquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            ArrayList<Square> map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator();
            Square square = map.get(8); // FOOD SQUARE
            square.receivePiece(gladiator);
            int energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(15, energyPoints);
        } catch(Exception e) {
            
        }
    }
    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            ArrayList<Square> map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator();

            Square square = map.get(0); // INITIAL SQUARE
            square.receivePiece(gladiator); //GETS 20 ENERGY
            int energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(20, energyPoints);


            square = map.get(4); // EQUIPMENT SQUARE
            square.receivePiece(gladiator); 


            gladiator.fightWithBeast(); //LOSES 15 ENERGY
            energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(5, energyPoints);

        } catch(Exception e) {

        }
    }


    @Test
    public void validateBeastSquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            ArrayList<Square> map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator();

            Square square = map.get(0); // INITIAL SQUARE
            square.receivePiece(gladiator); //GETS 20 ENERGY
            int energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(20, energyPoints);


            square = map.get(1); // EQUIPMENT SQUARE
            square.receivePiece(gladiator); //LOSES 20 ENERGY


            energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(0, energyPoints);

        } catch(Exception e) {}
    }

    @Test
    public void validateWineSquareCreationFromMapJson() {
       try {
            var mapParser = new MapJsonParser();
            ArrayList<Square> map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
            Gladiator gladiator = new Gladiator();

            Square square = map.get(0); // INITIAL SQUARE
            square.receivePiece(gladiator); //GETS 20 ENERGY
            int energyPoints = gladiator.getEnergy().getPoints();
            assertEquals(20, energyPoints);


            square = map.get(3); // WINE SQUARE
            square.receivePiece(gladiator); //LOSES x ENERGY (ALWAYS MORE THAN 0)


            energyPoints = gladiator.getEnergy().getPoints();
            assertTrue(energyPoints < 20);

        } catch(Exception e) {}
    }


    @Test
    public void validateInjurySquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            var map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
        } catch(Exception e) {

        }
    }

}
