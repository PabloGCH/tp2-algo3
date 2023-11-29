package edu.fiuba.algo3.modelo;

import java.io.File;

public enum Resources {
    MAP_STYLE_PATH("/styles/map.css"),
    SQUARE_STYLE_PATH("/styles/square.css"
    );


    private String value = "";

    Resources(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
