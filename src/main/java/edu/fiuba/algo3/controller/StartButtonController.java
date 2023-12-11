package edu.fiuba.algo3.controller;

import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.Square;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StartButtonController {
    public boolean validateNames(ArrayList<TextField> nameFields) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        boolean namesAreCorrect = true;
        Set<String> uniqueNames = new HashSet<>();

        for (TextField nameField : nameFields) {
            nameField.setStyle("-fx-border-color: transparent;");
            String name = nameField.getText().trim();

            if (name.length() < 4 || !uniqueNames.add(name)) {
                nameField.setStyle("-fx-border-color: red;");
                namesAreCorrect = false;
            }
        }
        if (namesAreCorrect) {
            this.newGame(nameFields);
        }
        return namesAreCorrect;
    }

    public void newGame(ArrayList<TextField> nameFields) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        ArrayList<String> gladiatorsNames = new ArrayList<String>();
        for (TextField name : nameFields) {
            String gladiatorName = name.getText();
            gladiatorsNames.add(gladiatorName);
        }
        MapFacade mapFacade = new MapFacade();
        ArrayList<Square> map = mapFacade.loadMap();
        Game.getInstance(gladiatorsNames, map);
        Game.getInstance().startGame();
    }
}
