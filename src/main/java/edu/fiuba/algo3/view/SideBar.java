package edu.fiuba.algo3.view;

import edu.fiuba.algo3.modelo.game.Game;
import edu.fiuba.algo3.modelo.gladiator.Gladiator;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class SideBar {

     public GridPane view(Game game){
        
        GridPane mapGridPane = new GridPane();
        VBox vBoxgeneral = new VBox(10);

        for (Gladiator gladiator : game.getGladiators()) {
            SideBarGladiator sideBarGladiator = new SideBarGladiator();
            gladiator.addObserver(sideBarGladiator);
            vBoxgeneral.getChildren().add(sideBarGladiator.view());
            
        }
        
        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(vBoxgeneral);

        mapGridPane.add(stackPane, 2000, 4000);
        mapGridPane.setStyle("-fx-background-color: gray;");

        return mapGridPane;
    }
}
