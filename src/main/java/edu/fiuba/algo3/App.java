package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.facade.MapFacade;


import edu.fiuba.algo3.modelo.squares.Square;
import edu.fiuba.algo3.view.GladiatorView;
import edu.fiuba.algo3.view.InitialView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    ArrayList<TextField> nameFields = new ArrayList<TextField>();
    @Override
    public void start(Stage stage) {

        Scene initialScene = new InitialView().initialScene(stage, nameFields);
        initialScene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());
        stage.setScene(initialScene);
        Image icon = new Image(getClass().getResource("/img/icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}