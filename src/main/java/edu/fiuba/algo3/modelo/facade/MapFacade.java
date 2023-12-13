package edu.fiuba.algo3.modelo.facade;

import edu.fiuba.algo3.modelo.mapJsonParser.*;
import edu.fiuba.algo3.modelo.squares.Square;
import javafx.geometry.Dimension2D;
import java.io.File;
import java.util.ArrayList;

public class MapFacade implements TerrainFacade{
    private String fileSource;
    private String fileName;
    public MapFacade() {
        this.fileSource = "src" + File.separator + "main" + File.separator + "resources"+ File.separator + "files" + File.separator + "map.json";
        this.fileName = "map.json";
    }
    public ArrayList<Square> loadMap() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        MapJsonParser mapParser = new MapJsonParser();
        return mapParser.loadMap(fileSource, fileName);
    }
    public Dimension2D mapDimensions() throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        MapJsonParser mapParser = new MapJsonParser();
        return mapParser.obtainDimension(fileSource);
    }
}