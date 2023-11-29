package edu.fiuba.algo3.modelo;

import java.io.File;

public enum Resources {
    MAP_STYLE_PATH(
        File.separator +
        "styles" +
        File.separator +
        "map.css"
    ),
    SQUARE_STYLE_PATH(
        File.separator +
        "styles" +
        File.separator +
        "square.css"
    );


    private String value = "";

    Resources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
