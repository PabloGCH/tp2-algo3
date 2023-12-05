package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.controller.MapController;
import edu.fiuba.algo3.controller.StartButtonController;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.facade.MapFacade;


import edu.fiuba.algo3.modelo.squares.Square;
import edu.fiuba.algo3.view.InitialView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
        stage.setResizable(false);
        stage.show();
    }

    public Scene mapScene() {
        MapFacade mapFacade = new MapFacade();

        /*edu.fiuba.algo3.modelo.map.Map map =
        new edu.fiuba.algo3.modelo.map.Map(
            15,
            15,
            new ArrayList<Position>()
        );*/ //SHOULD BE REPLACED BY "mapFacade.loadMap()"

        MapController mapController = new MapController(new ArrayList<Square>());
        return new Scene(mapController.draw());
    }

    public static void main(String[] args) {
        launch();
    }

}