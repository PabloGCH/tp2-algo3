package edu.fiuba.algo3;


import edu.fiuba.algo3.modelo.Messenger;
import edu.fiuba.algo3.view.InitialView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.apache.logging.log4j.LogManager;


/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) {

        Messenger.getInstance(LogManager.getLogger("AlgoRoma"));
        stage.setScene(new Scene(new InitialView().initialScene(stage)));
        stage.getScene().getStylesheets().add(getClass().getResource("/styles/initialScene.css").toExternalForm());
        Image icon = new Image(getClass().getResource("/img/icon.png").toExternalForm());
        stage.getIcons().add(icon);
        stage.setResizable(false);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }

}