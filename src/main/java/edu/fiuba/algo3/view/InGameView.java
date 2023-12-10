package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.DiceButtonController;
import edu.fiuba.algo3.modelo.facade.MapFacade;
import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import edu.fiuba.algo3.modelo.squares.Square;
import javafx.application.Platform;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;

public class InGameView {
    
   // public void displayInGameScene(Stage stage, ArrayList<Gladiator> gladiators) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {


    public void displayInGameScene(Stage stage) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        int squareWidth = 65;
        int squareHeight = 65;
        
        stage.setResizable(true);
        stage.setMaximized(true);
        MenuBar menuBar = createMenuBar(stage);

        double gridSize = Math.min(stage.getHeight(), stage.getWidth());
        Game aGame = Game.getInstance();
        Dimension2D dimensions = new MapFacade().mapDimensions();
        int width = (int) dimensions.getWidth();
        int height = (int) dimensions.getHeight();
        GridPane mapGridPane = new GridPane();
        GridPane stateGladiator = new SideBar().view(aGame);
        ArrayList<Square> path = aGame.getPath();


        for (int row = 0; row < height; row++) {
            for (int column = 0; column < width; column++) {
                Pane square = new Pane();
                square.setPrefSize(squareWidth, squareHeight);
                mapGridPane.add(square, row, column);
            }
        }
        
        Image pathImage = new Image(getClass().getResource("/img/path.png").toExternalForm());
        
        HashMap<String, Pane> mapGladiatorGrids = new HashMap<>();

        for (Square square : path) {
            Dimension2D coordinates = square.getPosition().coordinates();
            int xPosition = (int) coordinates.getWidth() - 1, yPosition = (int) coordinates.getHeight() - 1;
            var effectNames = square.getEffectNames();
            Pane squareGladiatorGrid = (new SquareView()).addPathToMapGrid(xPosition, yPosition, squareWidth, squareHeight, mapGridPane, effectNames);
            mapGladiatorGrids.put(xPosition + "-" + yPosition, squareGladiatorGrid);
        }
 

        //GLADIATORS ARE POSITIONATED IN INITIAL SQUARE
        for (Gladiator gladiator : aGame.getGladiators()) {
            System.err.println("gladiatorview");
            GladiatorView view = new GladiatorView(mapGladiatorGrids);
            gladiator.addObserver(view);
            var square = path.get(0);
            square.affect(gladiator);
        }

        

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(mapGridPane);
        borderPane.setRight(stateGladiator);
        borderPane.setBottom(bottomMenu());

        mapGridPane.getStyleClass().add("map-grid");
        stage.getScene().setRoot(borderPane);
        stage.setTitle("Algo Roma");
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/map.css").toExternalForm());
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/bottom-menu.css").toExternalForm());
    }
    private MenuBar createMenuBar(Stage stage) {
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(e -> Platform.exit());
        exitItem.getStyleClass().add("menu-item");

        MenuItem fullScreenItem = new MenuItem("Full screen");
        fullScreenItem.setOnAction(e -> toggleFullScreen(stage));
        fullScreenItem.getStyleClass().add("menu-item");


        Menu fileMenu = new Menu("File");
        fileMenu.getItems().add(exitItem);
        fileMenu.getItems().add(fullScreenItem);
        fileMenu.getStyleClass().add("menu");


        CheckMenuItem toggleMusic = new CheckMenuItem("Music on");
        toggleMusic.getStyleClass().add("menu-item");
        Menu musicList = new Menu("Select track");
        musicList.getStyleClass().add("menu-item");
        MenuItem firstTrack = new MenuItem("track 1");
        firstTrack.getStyleClass().add("menu-item");
        MenuItem secondTrack = new MenuItem("track 2");
        secondTrack.getStyleClass().add("menu-item");
        musicList.getItems().add(firstTrack);
        musicList.getItems().add(secondTrack);


        Menu musicMenu = new Menu("Music");
        musicMenu.getItems().add(toggleMusic);
        musicMenu.getItems().addAll(musicList);


        MenuItem howToPlay = new MenuItem("How to play");
        howToPlay.getStyleClass().add("menu-item");
        MenuItem about = new MenuItem("About");
        about.getStyleClass().add("menu-item");


        Menu help = new Menu("Help");
        help.getStyleClass().add("menu");
        help.getItems().add(howToPlay);
        help.getItems().add(about);


        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);
        menuBar.getMenus().addAll(musicMenu);
        menuBar.getMenus().addAll(help);
        menuBar.getStyleClass().add("menu-bar");

        return menuBar;
    }


    private void toggleFullScreen(Stage stage) {
        stage.setFullScreen(!stage.isFullScreen());
    }
    
    private Pane bottomMenu() {
        DiceButtonController diceButtonController = new DiceButtonController();
        GridPane bottomMenu = new GridPane();
        Button diceButton = new Button("Throw dice");
        diceButton.setOnAction(e ->{diceButtonController.throwDice();});
        bottomMenu.getStyleClass().add("bottom-menu");
        diceButton.getStyleClass().add("dice-button");
        bottomMenu.getChildren().add(diceButton);
        bottomMenu.setPrefHeight(80);
        return bottomMenu;
    }

}
