package edu.fiuba.algo3.controller;

import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class StartButtonController {
    public boolean validateNames(ArrayList<TextField> nameFields) {
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
        return namesAreCorrect;
    }
}
