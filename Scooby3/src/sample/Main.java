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
import javafx.scene.layout.BackgroundImage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private SFD answ;
    private int sfd = -1;
    private int height = 510;
    private int width = 300;
    private int buttonWidth = 80;
    private int tablePointer = 0;

    private int rowPosition = 0;


    public void start(Stage primaryStage) {

        GridPane grid = makeGridpane();
        Scene scene = new Scene(grid, height, width);
        primaryStage.setScene(scene);

        primaryStage.setTitle("ScoobyScript");

        //FrontPage Stuff
        //Title
        Text title = new Text("ScoobyScript");
        title.setFont(Font.font("Roboto", FontWeight.BOLD, 20));
        grid.add(title, 0, rowPosition++, 1, 1);

        //TextFields
        Label aValue = new Label("Write \"a\" value:");
        TextField aField = makeSameField(60,60);

        HBox aRowBox = new HBox(10);
        aRowBox.setAlignment(Pos.CENTER_LEFT);
        aRowBox.getChildren().addAll(aValue,aField);

        Label bValue = new Label("Write \"b\" value:");
        TextField bField = makeSameField(60,60);

        HBox bRowBox = new HBox(10);
        bRowBox.setAlignment(Pos.CENTER_LEFT);
        bRowBox.getChildren().addAll(bValue,bField);

        //Adds input boxes
        rowPosition = 2;
        grid.add(aRowBox, 0, rowPosition++);
        grid.add(bRowBox,0,rowPosition++);

        //----Makes buttons----//


        //CommitButton
        Button commitBtn = makeSameButton("Commit!",buttonWidth,buttonWidth);
        Label commitAction = makeSameLabel();
        commitAction.setId("Error");

        HBox commitBox = makeBox();
        commitBox.getChildren().addAll(commitBtn, commitAction);

        grid.add(commitBox, 0, rowPosition++);

        //LatexButton
        Button latexBtn = makeSameButton("LatexMe!", buttonWidth,buttonWidth);
        Label latexAction = makeSameLabel();
        latexAction.setId("Error");


        HBox latexBox = makeBox();
        latexBox.getChildren().addAll(latexBtn, latexAction);

        grid.add(latexBox,0,rowPosition++);

        //TableButton
        Button tableBtn = makeSameButton("TableMe!",buttonWidth,buttonWidth);
        Label tableAction = makeSameLabel();
        tableAction.setId("Error");

        HBox tableBox = makeBox();
        tableBox.getChildren().addAll(tableBtn, tableAction);

        grid.add(tableBox,0,rowPosition++);

        //CommitAction
        commitBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                resetButtons(commitAction,latexAction,tableAction);

                String a = aField.getText();
                String b = bField.getText();

                if(!isInt(a,b)){
                    answ = null;
                    commitAction.setTextFill(Color.FIREBRICK);
                    commitAction.setText("Not a valid input!");
                    return;
                }
                calcSFD(Integer.parseInt(a),Integer.parseInt(b));
                sfd = answ.getSFD();

                commitAction.setTextFill(Color.FORESTGREEN);
                commitAction.setText("SFD: " + sfd);
            }
        });

        latexBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                resetButtons(latexAction,tableAction);
                if(answ == null){
                    latexAction.setTextFill(Color.FIREBRICK);
                    latexAction.setText("No SFD value");
                    return;
                }

                answ.latexMeSFD();
                latexAction.setTextFill(Color.FORESTGREEN);
                latexAction.setText("Copied to Clipboard!");
            }
        });


        GridPane tableGrid = makeGridpane();
        Scene tableScene = new Scene(tableGrid, height, width);

        Text tableTxt = new Text("TableOverview");
        tableTxt.setFont(Font.font("Roboto", FontWeight.BOLD, 20));

        tableGrid.add(tableTxt, 0,tablePointer++);

        tableBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if(answ == null){
                    tableAction.setTextFill(Color.FIREBRICK);
                    tableAction.setText("No SFD value");
                    return;
                }
                makeTable(tableGrid);

                Button backBtn = makeSameButton("Back", buttonWidth,buttonWidth);
                tableGrid.add(backBtn,0,tablePointer);

                backBtn.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        primaryStage.setScene(scene);
                        tableGrid.getChildren().clear();
                    }
                });

                primaryStage.setScene(tableScene);
            }
        });

        //Todo implement sound


        primaryStage.show();
    }


    //Makes the table
    private void makeTable(GridPane tableGrid){
        HBox top = makeBox();
        Label[] topLbl = new Label[5];
        topLbl[0] = makeSameSizeText("Itt");
        topLbl[1] = makeSameSizeText("Q");
        topLbl[2] = makeSameSizeText("Rest");
        topLbl[3] = makeSameSizeText("s");
        topLbl[4] = makeSameSizeText("t");
        top.getChildren().addAll(topLbl);
        tableGrid.add(top,0,tablePointer++);

        HBox tempBox;
        Label[] tempLbl;
        String[] tempStr;
        for(int i = 0; i <= answ.getPointer(); i++){
            tempBox = makeBox();

            tempStr = answ.getStrings(i);

            for(int j = 0; j < 5; j++){
                tempBox.getChildren().add(makeSameSizeText(tempStr[j]));
            }
            tableGrid.add(tempBox,0,tablePointer++);
        }

    }


    //Does the SFD command
    private void calcSFD(int a, int b){
        this.answ = new SFD(a, b);
        sfd = answ.getSFD();
    }
    //Checks if string is in
    private boolean isInt(String a, String b){
        if(a.matches("-?(0|[1-9]\\d*)") && b.matches("-?(0|[1-9]\\d*)")) return true;
        return false;
    }
    //Makes min-max px TextField
    private TextField makeSameField(double min, double max){
        TextField returnText = new TextField();
        returnText.setMinWidth(min);
        returnText.setMaxWidth(max);
        return returnText;
    }
    //Makes HBox. Spacing: 10, allignment Pos.TOP_LEFT
    private HBox makeBox(){
        HBox returnBox = new HBox(10);
        returnBox.setAlignment(Pos.CENTER_LEFT);
        return returnBox;
    }
    //Makes min-max px Button
    private Button makeSameButton(String text, double min, double max){
        Button returnBtn = new Button(text);
        returnBtn.setMinWidth(min);
        returnBtn.setMaxWidth(max);
        return returnBtn;
    }
    //Makes labels with roboto font
    private Label makeSameLabel(){
        Label returnLabel = new Label();
        returnLabel.setFont(Font.font("Roboto", FontWeight.BOLD,12));
        return returnLabel;
    }
    //Makes same size of box around text
    private Label makeSameSizeText(String str){
        Label returnLbl = new Label(str);
        int width = 30;
        returnLbl.setMaxWidth(width);
        returnLbl.setMinWidth(width);
        return returnLbl;
    }
    //resets 3 Labels
    private void resetButtons(Label a, Label b, Label c){
        a.setTextFill(Color.BLACK);
        b.setTextFill(Color.BLACK);
        c.setTextFill(Color.BLACK);
        a.setText("");
        b.setText("");
        c.setText("");
    }
    //resets 2 Labels
    private void resetButtons(Label a, Label b){
        a.setTextFill(Color.BLACK);
        b.setTextFill(Color.BLACK);
        a.setText("");
        b.setText("");
    }
    //Makes same gridPane
    private GridPane makeGridpane(){
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.TOP_LEFT);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,10,25,10));

        BackgroundImage myBI= new BackgroundImage(new Image("sample/Scooby.jpg",510,300,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        grid.setBackground(new Background(myBI));

        return grid;
    }

}
