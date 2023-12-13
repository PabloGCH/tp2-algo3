package edu.fiuba.algo3.modelo.mapJsonParser;

public class MapFileFailedToOpenOrClose extends Exception {
    public MapFileFailedToOpenOrClose() {
        super("The map file failed to open or close");
    }
}