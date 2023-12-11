package edu.fiuba.algo3.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class AboutView implements EventHandler<ActionEvent> {
    @Override
    public void handle(ActionEvent actionEvent) {
        Image icon = new Image(getClass().getResource("/img/icon.png").toExternalForm());
        ImageView imageView = new ImageView();
        imageView.setFitWidth(150);
        imageView.setFitHeight(150);
        imageView.setImage(icon);
        VBox iconBox = new VBox();
        iconBox.getChildren().add(imageView);
        Label title = new Label("AlgoRoma");
        Label authorsTitle = new Label("Authors");
        VBox titleBox = new VBox(25);
        titleBox.getChildren().addAll(title, authorsTitle);
        titleBox.setAlignment(Pos.CENTER);
        Label authorsOne = new Label("Pablo, Zoilo, Mariano");
        Label authorsTwo = new Label("Geronimo, Luciano");
        VBox authorsBox = new VBox(5);
        authorsBox.getChildren().addAll(authorsOne, authorsTwo);
        authorsBox.setAlignment(Pos.CENTER_LEFT);
        Label inspectorsTitle = new Label("Inspectors");
        VBox inspectorsTitleBox = new VBox();
        inspectorsTitleBox.getChildren().add(inspectorsTitle);
        inspectorsTitleBox.setAlignment(Pos.CENTER);
        Label inspectors = new Label("inspector 1, inspector 2");
        VBox credits = new VBox(15);
        credits.getChildren().addAll(titleBox, authorsBox, inspectorsTitleBox,inspectors);
        credits.setAlignment(Pos.CENTER_LEFT);
        HBox canvas = new HBox();
        canvas.getChildren().addAll(iconBox, credits);
        StackPane aboutPane = new StackPane();
        aboutPane.getChildren().add(canvas);
        aboutPane.getStyleClass().add("gladiator-card");
        aboutPane.setPadding(new Insets(5));
        Scene aboutScene = new Scene(aboutPane);
        aboutScene.getStylesheets().add(getClass().getResource("/initialScene.css").toExternalForm());
        Stage aboutStage = new Stage();
        aboutStage.setScene(aboutScene);
        aboutStage.setResizable(false);
        aboutStage.setTitle("About");
        aboutStage.show();
    }
}
