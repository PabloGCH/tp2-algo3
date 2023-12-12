package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SideBar {

     public GridPane view(Game game){
        
        GridPane sidebarPane = new GridPane();
        VBox vBoxgeneral = new VBox(10);

        for (Gladiator gladiator : game.getGladiators()) {
            SideBarGladiator sideBarGladiator = new SideBarGladiator();
            gladiator.addObserver(sideBarGladiator);
            vBoxgeneral.getChildren().add(sideBarGladiator.view());
        }
        
        StackPane gladiatorsList = new StackPane();
        gladiatorsList.getChildren().addAll(vBoxgeneral);

        ScrollPane scrollable = new ScrollPane(gladiatorsList);
        scrollable.setBackground(
            new Background(new BackgroundFill(Color.GRAY, null, null))
        );
        scrollable.setBorder(new Border(new BorderStroke(Color.GRAY, null, null, null)));

        sidebarPane.add(scrollable, 2000, 4000);
        sidebarPane.setStyle("-fx-background-color: gray;");
        gladiatorsList.setStyle("-fx-background-color: gray;");

        return sidebarPane;
    }
}