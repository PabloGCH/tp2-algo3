package edu.fiuba.algo3.modelo.facade;

import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public class MapFacade {
    private String fileSource;
    private String fileName;
    public MapFacade() {
        this.fileSource = "src\\main\\resources\\files\\map.json";
        this.fileName = "map.json";
    }

    public ArrayList<Square> loadMap() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        MapJsonParser mapParser = new MapJsonParser();
        return mapParser.loadMap(fileSource, fileName);
    }
}
