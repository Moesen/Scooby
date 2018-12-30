package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

public class Main extends Application {


    public void start(Stage primaryStage) throws Exception{

        GridPane grid = makeGrid();


    }


    public static void main(String[] args) {
        launch(args);
    }

    private GridPane makeGrid(){
        GridPane returnGrid = new GridPane();
        returnGrid.setVgap(10);
        returnGrid.setHgap(10);
        returnGrid.setAlignment(Pos.TOP_LEFT);
        returnGrid.setPadding(new Insets(10,10,10,10));
        return returnGrid;
    }

}
