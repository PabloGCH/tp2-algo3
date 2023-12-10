package edu.fiuba.algo3.view;

import edu.fiuba.algo3.controller.StartButtonController;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import edu.fiuba.algo3.modelo.mapJsonParser.InvalidMapFile;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileCouldNotBeParsed;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileFailedToOpenOrClose;
import edu.fiuba.algo3.modelo.mapJsonParser.MapFileNotFound;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class InitialView {
    private final int MAX_PLAYERS_AMOUNT = 6;
    private final int MIN_PLAYERS_AMOUNT = 2;
    private final int PLAYERS_PER_ROW = 3;
    private final int PLAYERS_PER_COLUMN = 2;

    ArrayList<TextField> nameFields;
    public Scene initialScene(Stage stage, ArrayList nameFields) {
        this.nameFields = nameFields;
        VBox mainContainer = new VBox();
        mainContainer.getStyleClass().add("main-container");
        Label invalidNamesText = new Label("Los nombres deben ser únicos y de al menos 4 caracteres");
        invalidNamesText.getStyleClass().add("invalid-name");
        invalidNamesText.setWrapText(true);
        invalidNamesText.setPadding(new Insets(10, 10, 0, 10));
        invalidNamesText.setVisible(false);
        GridPane grid = new GridPane();

        int playersCreated = 0;
        for (int column = 0; column < PLAYERS_PER_COLUMN; column++) {
            for (int row = 0; row < PLAYERS_PER_ROW; row++) {
                if (playersCreated < MIN_PLAYERS_AMOUNT) {
                    grid.add(createDefaultGladiator(), row, column);
                    playersCreated++;
                } else if (playersCreated < MAX_PLAYERS_AMOUNT){
                    grid.add(newAddCard(), row, column);
                    playersCreated++;
                }
            }
        }

        grid.setPadding(new Insets(10));
        mainContainer.setAlignment(Pos.CENTER);
        mainContainer.getChildren().add(grid);
        Button startButton = new Button("StartGame");
        startButton.getStyleClass().add("start-game-btn");
        startButton.setOnAction(event -> {
            invalidNamesText.setVisible(false);
            StartButtonController controller = new StartButtonController();
            try {
                if (controller.validateNames(this.nameFields)) {
                    new InGameView().displayInGameScene(stage);
                }
            } catch (MapFileNotFound e) {
                throw new RuntimeException(e);
            } catch (MapFileFailedToOpenOrClose e) {
                throw new RuntimeException(e);
            } catch (MapFileCouldNotBeParsed e) {
                throw new RuntimeException(e);
            } catch (InvalidMapFile e) {
                throw new RuntimeException(e);
            }
            invalidNamesText.setVisible(true);
        });
        startButton.getStyleClass().add("btn");
        mainContainer.getChildren().add(startButton);
        mainContainer.getChildren().add(invalidNamesText);
        mainContainer.setPrefWidth(150*PLAYERS_PER_ROW + 20);
        mainContainer.setPadding(new Insets(0, 0, 10, 0));
        Scene scene = new Scene(mainContainer);

        scene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());

        return scene;
    }

    private VBox newAddCard() {
        VBox aVBox = new VBox();
        aVBox.setPrefSize(150, 150);
        aVBox.getStyleClass().add("gladiator-card");
        aVBox.setAlignment(Pos.CENTER);
        aVBox.setPadding(new Insets(5));
        aVBox.getChildren().add(setAddButton(aVBox));
        return aVBox;
    }
    private Button setAddButton(VBox vBox) {
        Button addButton = new Button("+");
        addButton.getStyleClass().add("plus-sign");
        addButton.getStyleClass().add("btn");
        addButton.setOnAction(e -> addGladiator(vBox));
        return addButton;
    }
    private VBox createDefaultGladiator() {
        VBox newGladiatorInfo = new VBox();
        newGladiatorInfo.setPrefSize(150, 150);
        newGladiatorInfo.getStyleClass().add("gladiator-card");
        newGladiatorInfo.setAlignment(Pos.CENTER);
        newGladiatorInfo.setPadding(new Insets(5));
        TextField gladiatorNameField = new TextField();
        this.nameFields.add(gladiatorNameField);
        gladiatorNameField.getStyleClass().add("name-field");
        Label nameLabel = new Label("Nombre");
        nameLabel.getStyleClass().add("name-label");
        nameLabel.setLabelFor(gladiatorNameField);
        newGladiatorInfo.getChildren().add(nameLabel);
        newGladiatorInfo.getChildren().add(gladiatorNameField);
        return newGladiatorInfo;
    }
    private void addGladiator(VBox container) {
        container.getChildren().clear();

        Label nameLabel = new Label("Nombre");
        TextField gladiatorNameField = new TextField();
        nameLabel.getStyleClass().add("name-label");
        gladiatorNameField.getStyleClass().add("name-field");
        this.nameFields.add(gladiatorNameField);
        nameLabel.setLabelFor(gladiatorNameField);
        Button deleteGladiator = new Button("-");
        deleteGladiator.getStyleClass().add("btn");
        container.getChildren().add(nameLabel);
        container.getChildren().add(gladiatorNameField);
        container.getChildren().add(deleteGladiator);
        deleteGladiator.setOnAction(e -> removeGladiator(container, gladiatorNameField));
    }

    private void removeGladiator(VBox gladiatorField, TextField nameField) {
        gladiatorField.getChildren().clear();
        gladiatorField.getChildren().add(setAddButton(gladiatorField));
        this.nameFields.remove(nameField);
    }
}
