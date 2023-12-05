package edu.fiuba.algo3.modelo.mapJsonParser;

import edu.fiuba.algo3.modelo.squares.Square;

import java.util.ArrayList;

public interface Parser {
    public ArrayList<Square> loadMap(String filePath, String fileName) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile;
}
