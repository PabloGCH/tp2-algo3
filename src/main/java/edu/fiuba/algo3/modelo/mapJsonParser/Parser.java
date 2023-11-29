package edu.fiuba.algo3.modelo.mapJsonParser;

import edu.fiuba.algo3.modelo.map.Map;
import edu.fiuba.algo3.modelo.squares.Square;
import org.json.simple.JSONArray;

import java.util.ArrayList;

public interface Parser {
    public Map loadMap(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile;
}
