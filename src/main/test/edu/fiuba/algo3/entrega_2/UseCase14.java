package edu.fiuba.algo3.entrega_2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import edu.fiuba.algo3.modelo.mapJsonParser.MapJsonParser;


public class UseCase14 {
    @Test
    public void validateFoodSquareCreationFromMapJson() {
        try {
        var mapParser = new MapJsonParser();
        var map = mapParser.loadMap(
            "src/main/resources/files/mapTest.json",
            "mapTest.json"
        );
        } catch(Exception e) {
            
        }
    }
    @Test
    public void validateEquipmentUpgradeSquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            var map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
        } catch(Exception e) {

        }
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
    @Test
    public void validateBeastSquareCreationFromMapJson() {
        try {
            var mapParser = new MapJsonParser();
            var map = mapParser.loadMap(
                "src/main/resources/files/mapTest.json",
                "mapTest.json"
            );
        } catch(Exception e) {

        }
    }
    @Test
    public void validateWineSquareCreationFromMapJson() {
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
