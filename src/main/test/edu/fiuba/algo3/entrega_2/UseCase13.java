package edu.fiuba.algo3.entrega_2;

import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.mapJsonParser.MapJsonParser;
import static org.junit.jupiter.api.Assertions.*;


public class UseCase13 {
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
}
