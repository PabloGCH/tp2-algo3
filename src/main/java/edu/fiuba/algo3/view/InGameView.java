package edu.fiuba.algo3.view;

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
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class InGameView {
    private ArrayList<String> songsList = new ArrayList<>();
    public void displayInGameScene(Stage stage) throws MapFileNotFound, MapFileFailedToOpenOrClose, MapFileCouldNotBeParsed, InvalidMapFile {
        this.loadSoundsAndMusic();
        if (!songsList.isEmpty()) {
            Sound.getInstance().playLoopedMusic(songsList.get(0));
        }
        int squareWidth = 65;
        int squareHeight = 65;
        
        stage.setResizable(true);
        MenuBar menuBar = createMenuBar(stage);

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

        StackPane mapStackPane = new StackPane();
        
        TurnCounterView turnCounter = new TurnCounterView();
        Pane turnCounterView = turnCounter.view();
        ScrollPane mapScrollPane = new ScrollPane(mapGridPane);

        aGame.addObserver(turnCounter);

        mapStackPane.getChildren().add(mapScrollPane);
        mapStackPane.getChildren().add(turnCounterView);

        mapScrollPane.setPannable(true);
        mapScrollPane.setStyle("-fx-background-color: #413d3d;");
        mapScrollPane.setBorder(new Border(new BorderStroke(new Color((double) 65 /255, (double) 61 /255, (double) 61 /255, (double) 1 /255), null, null, null)));

        mapScrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
        mapScrollPane.setVbarPolicy(ScrollBarPolicy.NEVER);

        mapScrollPane.setBackground(
            new Background(new BackgroundFill(Color.TRANSPARENT, null, null))
        );

        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

        int sceneHeight = (int)(screenHeight * (0.9));

        stage.setWidth(screenWidth);
        stage.setHeight(sceneHeight);
        stage.centerOnScreen();

        stage.setMaximized(true);

        gamePane.setCenter(mapStackPane);
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
            track.setOnAction(e -> Sound.getInstance().playLoopedMusic(song));
        }

        Menu musicMenu = new Menu("Music");
        musicMenu.getItems().add(toggleMusic);
        musicMenu.getItems().addAll(musicList);


        MenuItem howToPlay = new MenuItem("How to play");
        howToPlay.getStyleClass().add("menu-item");
        HowToPlayView howToPlayView = new HowToPlayView();
        howToPlay.setOnAction(howToPlayView);
        MenuItem about = new MenuItem("About");
        about.getStyleClass().add("menu-item");
        AboutView aboutView = new AboutView();
        about.setOnAction(aboutView);

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
        String soundsFXDirectory = "/sounds/soundsFX";

        try {
            URL resource = getClass().getResource(songsDirectory);

            File[] files = new File(resource.toURI()).listFiles();

            if (files != null) {

                String[] mp3Files = Arrays.stream(files)
                        .filter(file -> file.isFile() && file.getName().toLowerCase().endsWith(".mp3"))
                        .map(File::getName)
                        .toArray(String[]::new);

                for (String song : mp3Files) {
                    sounds.loadMusic(song, song);
                    songsList.add(song);
                }
            } else {
                System.out.println("No se encontraron archivos MP3");
            }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Sound.getInstance().loadMusic("gameOver/victory.mp3", "victory.mp3");
        Sound.getInstance().loadMusic("gameOver/lose.mp3", "lose.mp3");

        try {
            URL resource = getClass().getResource(soundsFXDirectory);

            File[] files = new File(resource.toURI()).listFiles();

            if (files != null) {

                String[] mp3Files = Arrays.stream(files)
                        .filter(file -> file.isFile() && file.getName().toLowerCase().endsWith(".mp3"))
                        .map(File::getName)
                        .toArray(String[]::new);

                for (String soundfx : mp3Files) {
                    sounds.loadSound(soundfx, soundfx);
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