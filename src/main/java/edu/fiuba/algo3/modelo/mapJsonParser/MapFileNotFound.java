package edu.fiuba.algo3.modelo.mapJsonParser;

public class MapFileNotFound extends Exception {
    public MapFileNotFound() {
        super("The map file was not found");
    }
}