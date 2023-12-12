package edu.fiuba.algo3.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Properties;

public class HowToPlayView implements EventHandler<ActionEvent> {
    private int currentPage;
    private HBox mainContainer = new HBox();
    private HBox buttonsContainer = new HBox();
    private ImageView pageImageView = new ImageView();
    private Label pageLabel = new Label();
    private final Stage dialogStage = new Stage();
    private HashMap<String, String> texts = new HashMap<String, String>();
    private HashMap<String, Image> images = new HashMap<String, Image>();
    private Button nextButton = new Button("Next");
    private Button backButton = new Button("Back");
    private Label pageNumberLabel = new Label();
    public HowToPlayView() {
        this.mainContainer.getChildren().addAll(this.pageImageView, this.pageLabel);
        this.buttonsContainer.getChildren().addAll(backButton, pageNumberLabel, nextButton);

        this.backButton.getStyleClass().add("btn");
        this.nextButton.getStyleClass().add("btn");

        this.dialogStage.initModality(Modality.APPLICATION_MODAL);
        this.dialogStage.setTitle("How to play");
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        this.pageImageView.setFitWidth(150);
        this.pageImageView.setPreserveRatio(true);
        this.pageLabel.setWrapText(true);
        this.currentPage = 1;

        setUpPages();
        setUpStage();

        dialogStage.showAndWait();
    }

    private void setUpPages() {
        this.texts.put("1", "First page text");
        this.images.put("1", new Image(getClass().getResource("/img/beast.png").toExternalForm()));

        this.texts.put("2", "Second page text");
        this.images.put("2", new Image(getClass().getResource("/img/bacchanalia.png").toExternalForm()));
    }

    private void setUpStage() {

        VBox root = new VBox();
        root.setStyle("-fx-background-color: rgb(91, 53, 24)");

        this.pageLabel.setText(this.texts.get(String.valueOf(currentPage)));
        this.pageLabel.setAlignment(Pos.CENTER);
        this.pageLabel.setPadding(new Insets(10));
        this.pageImageView.setImage(this.images.get(String.valueOf(currentPage)));

        this.mainContainer.setPadding(new Insets(10));

        this.nextButton.setOnAction(e -> {
            this.currentPage++;
            updatePage();
        });
        this.pageNumberLabel.setText(this.currentPage + "/" + this.texts.size());
        pageNumberLabel.setPadding(new Insets(0, 10, 0, 10));
        this.backButton.setOnAction(e -> {
            this.currentPage--;
            updatePage();
        });
        this.nextButton.setDisable(this.currentPage == this.texts.size());
        this.backButton.setDisable(currentPage == 1);

        this.buttonsContainer.setPadding(new Insets(10));
        this.buttonsContainer.setAlignment(Pos.CENTER);

        root.getChildren().addAll(mainContainer, buttonsContainer);

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("/styles/initialScene.css").toExternalForm());
        dialogStage.setScene(scene);
    }

    private void updatePage() {
        this.pageLabel.setText(this.texts.get(String.valueOf(currentPage)));
        this.pageImageView.setImage(this.images.get(String.valueOf(currentPage)));

        this.nextButton.setDisable(this.currentPage == this.texts.size());
        this.backButton.setDisable(currentPage == 1);

        Label pageNumberLabel = new Label(this.currentPage + "/" + this.texts.size());
    }
}
