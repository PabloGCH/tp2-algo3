package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.facade.MapFacade;


import edu.fiuba.algo3.modelo.squares.Square;
import edu.fiuba.algo3.view.InitialView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {

        stage.setScene(new Scene(new InitialView().initialScene(stage)));
        stage.getScene().getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}