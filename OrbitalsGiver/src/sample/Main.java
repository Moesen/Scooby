package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.EventListener;

public class Main extends Application {

    Atoms atoms = new Atoms();

    private int rowPointer = 0;
    private TextField symboleField;
    private NumberTextField chargeField;
    Atom atom;

    private String symbole;
    private String charg;
    private Label infoTxt = new Label();
    private Label atomTxt = new Label();


    @Override
    public void start(Stage primaryStage) throws Exception{

        GridPane introGrid = makeGridpanel();
        Scene introStage = new Scene(introGrid,250,350);
        primaryStage.setTitle("Orbitalen");
        primaryStage.setScene(introStage);

        //FrontPage TextFields and buttons
        Text title = new Text("Orbitalen");
        title.setFont(Font.font("Ubuntu", FontWeight.BOLD,20));
        introGrid.add(title,1, rowPointer++,1,1);

        //Symbol added
        Label symbol = new Label("Symbol:");
        symboleField = makeTextField(60,60);

        HBox symboleRow = new HBox(10);
        symboleRow.setAlignment(Pos.CENTER_LEFT);
        symboleRow.getChildren().addAll(symbol, symboleField);

        introGrid.add(symboleRow, 1, rowPointer++);

        //Charge added
        Label charge = new Label("Charge:");
        chargeField = makeNumberTextField(60,60);

        HBox chargeRow = new HBox(10);
        chargeRow.setAlignment(Pos.CENTER_LEFT);
        chargeRow.getChildren().addAll(charge,chargeField);

        introGrid.add(chargeRow, 1, rowPointer++);

        //Adds processButton
        Button processAction = makeButton("Process!",100,100);

        HBox buttonRow = new HBox(10);
        buttonRow.setAlignment(Pos.CENTER_LEFT);
        buttonRow.getChildren().addAll(processAction);

        introGrid.add(buttonRow,1, rowPointer++);

        HBox infoRow = new HBox(10);
        infoRow.setAlignment(Pos.CENTER_LEFT);
        infoRow.getChildren().addAll(infoTxt);

        introGrid.add(infoRow,1,rowPointer++);





        processAction.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                resetInfoTxt();
                if(checkFields(symboleField, "No Symbol detected")) return;
                if(checkFields(chargeField, "No Charge detected")) return;

                symbole = symboleField.getText();
                charg = chargeField.getText();
                if(!charg.matches("-?\\d+")){
                    infoTxt.setText("Charge's not a valid value!");
                }

                atom = atoms.getAtom(symbole);
                if(atom.getSymbol().equals("")){
                    infoTxt.setText("Atom not found");
                }







            }
        });


        primaryStage.show();
    }




    public static void main(String[] args) {
        launch(args);
    }

    //Makes same gridPane
    private GridPane makeGridpanel(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10,10,10,10));


        return grid;
    }

    private TextField makeTextField(int minWidth, int maxWidht){
        TextField returnField = new TextField();
        returnField.setMaxWidth(maxWidht);
        returnField.setMinWidth(minWidth);
        return returnField;
    }

    private NumberTextField makeNumberTextField(int minWidth, int maxWidth){
        NumberTextField returnField = new NumberTextField();
        returnField.setMinWidth(minWidth);
        returnField.setMaxWidth(maxWidth);
        return returnField;
    }

    private Button makeButton(String text, int minWidth, int maxWidth){
        Button returnButton = makeButton(minWidth, maxWidth);
        returnButton.setText(text);
        return returnButton;
    }

    private void resetInfoTxt(){
        infoTxt.setTextFill(null);
        infoTxt.setText("");
    }

    private Button makeButton(int minWidth, int maxWidth){
        Button returnButton = new Button();
        returnButton.setMaxWidth(maxWidth);
        returnButton.setMinWidth(minWidth);
        return returnButton;
    }

    private boolean checkFields(TextField testField, String errorMessage){
        if(testField.getText() == null || testField.getText().trim().isEmpty()){
            infoTxt.setTextFill(Color.RED);
            infoTxt.setText(errorMessage);
        }
        return testField.getText() == null || testField.getText().trim().isEmpty();
    }


}
