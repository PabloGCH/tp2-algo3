package edu.fiuba.algo3.unittests.mapParserTest;

import edu.fiuba.algo3.modelo.mapJsonParser.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class mapDataJsonParser {
    @Test
    public void validateJSONExistsTest() {
        assertThrows(MapFileNotFound.class, () -> {
            var mapDataParser = new MapDataJsonParser();
            mapDataParser.loadData(
                    "src/main/resources/files/nonExistentFile.json",
                    "nonExistentFile.json"
            );
        });
    }
    @Test
    public void validateJSONHasWrongSyntax() {
        assertThrows(MapFileCouldNotBeParsed.class, () -> {
            var mapDataParser = new MapDataJsonParser();
            mapDataParser.loadData(
                    "src/main/resources/files/mapTestInvalidJsonSyntax.json",
                    "mapTestInvalidJsonSyntax.json"
            );
        });
    }
    @Test
    public void validateJSONIsHasWrongKeys() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapDataParser = new MapDataJsonParser();
            mapDataParser.loadData(
                    "src/main/resources/files/mapTestInvalidKeysInJson.json",
                    "mapTestInvalidKeysInJson.json"
            );
        });
    }
    @Test
    public void validateJSONMapWithoutMapaThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapDataParser = new MapDataJsonParser();
            mapDataParser.loadData(
                    "src/main/resources/files/mapWithoutMapa.json",
                    "mapWithoutMapa.json"
            );
        });
    }
    @Test
    public void validateJSONFileJSONArrayThrowsError() {
        assertThrows(InvalidMapFile.class, () -> {
            var mapDataParser = new MapDataJsonParser();
            mapDataParser.loadData(
                    "src/main/resources/files/JSONArray.json",
                    "NotJSONArray.json"
            );
        });
    }
    @Test
    public void validateCorrectDataIsExtracted() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        MapDataJsonParser mapDataParser = new MapDataJsonParser();
        ArrayList<Integer> data = mapDataParser.loadData(
                "src/main/resources/files/map.json",
                "map.json"
        );
        assertEquals(10, data.get(0));
        assertEquals(18, data.get(1));
    }
}
