package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.DiceButtonController;
import edu.fiuba.algo3.controller.Sound;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.paint.Color;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InGameView {
    
   // public void displayInGameScene(Stage stage, ArrayList<Gladiator> gladiators) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {

    private ArrayList<String> songsList = new ArrayList<>();

    public void displayInGameScene(Stage stage) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        this.loadSoundsAndMusic();
        if (!songsList.isEmpty()) {
            Sound.getInstance().playMusic(songsList.get(0));
        }
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

        stateGladiator.setPrefWidth(390);

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
 

        for (Gladiator gladiator : aGame.getGladiators()) {
            GladiatorView view = new GladiatorView(mapGladiatorGrids);
            gladiator.addObserver(view);
        }

        

        BorderPane mainLayout = new BorderPane();
        BorderPane gamePane = new BorderPane();

        ScrollPane mapScrollPane = new ScrollPane(mapGridPane);
        mapScrollPane.setPannable(true);
        mapScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        mapScrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);

        mapScrollPane.setBackground(
            new Background(new BackgroundFill(Color.TRANSPARENT, null, null))
        );

        gamePane.setCenter(mapScrollPane);
        var bottomMenu = new BottonMenu();
        aGame.addObserver(bottomMenu);
        gamePane.setBottom(bottomMenu.view());

        
        mainLayout.setTop(menuBar);
        mainLayout.setCenter(gamePane);
        mainLayout.setRight(stateGladiator);

        mapGridPane.getStyleClass().add("map-grid");
        stage.getScene().setRoot(mainLayout);
        stage.setTitle("Algo Roma");
        stage.getScene().getStylesheets().clear();
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/initialScene.css").toExternalForm());
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
        toggleMusic.setOnAction(e -> Sound.getInstance().toggleMuteMusic());

        for (String song : songsList) {
            MenuItem track = new MenuItem(song);
            track.getStyleClass().add("menu-item");
            musicList.getItems().add(track);
            track.setOnAction(e -> Sound.getInstance().playMusic(song));
        }

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

    private void loadSoundsAndMusic() {
        Sound sounds = Sound.getInstance();
        String songsDirectory = "/sounds/music";
        try {
            URL resource = getClass().getResource(songsDirectory);

            File[] files = new File(resource.toURI()).listFiles();

            if (files != null) {

                String[] mp3Files = Arrays.stream(files)
                        .filter(file -> file.isFile() && file.getName().toLowerCase().endsWith(".mp3"))
                        .map(File::getName)
                        .toArray(String[]::new);

                for (String song : mp3Files) {
                    URL fileURL = getClass().getResource(songsDirectory + "/" + song);

                    Media media = new Media(fileURL.toString());

                    sounds.loadMusic(song, song);
                    songsList.add(song);
                }
            } else {
                System.out.println("No se encontraron archivos MP3");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        sounds.modifyEffectVolume(50);
        sounds.modifyMusicVolume(25);
    }


    private void toggleFullScreen(Stage stage) {
        stage.setFullScreen(!stage.isFullScreen());
    }

}
