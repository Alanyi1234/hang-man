package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

import static javafx.stage.FileChooser.*;

public class Hangman extends Application {

    FileChooser fileChooser = new FileChooser();

    Right right = new Right();
    Left left = new Left();
    popEnd end = new popEnd();
    Boolean hasStarted = false;
    
    public void start(Stage primaryStage) throws Exception{
        Letter a = new Letter();

        BorderPane root = new BorderPane();


        Scene menu = new Scene(root, 600, 600);
        //root.setStyle();

        //Creating top Rectangle
        Rectangle topBar = new Rectangle(0,0,0,50);
        topBar.setFill(Color.GREEN);
        topBar.widthProperty().bind(menu.widthProperty());
        //Creat an H box to Make the buttons to store in the top
        HBox buttonCollection = new HBox();

        //Create buttons
        Image Load = new Image("Load.png");
        Image Exit = new Image("Exit.png");
        Image Save = new Image("Save.png");
        Image New = new Image("New.png");

        ImageView iv1 = new ImageView();
        iv1.setImage(Load);
        ImageView iv2 = new ImageView();
        iv2.setImage(Exit);
        ImageView iv3 = new ImageView();
        iv3.setImage(Save);
        ImageView iv4 = new ImageView();
        iv4.setImage(New);

        Button Load1 = new Button();
        Load1.setGraphic(iv1);

        Button Exit1 = new Button();
        Exit1.setGraphic(iv2);
        Button Save1 = new Button();
        Save1.setGraphic(iv3);
        Save1.setDisable(true);
        Save1.setId("SaveButton");
        Button New1 = new Button();
        New1.setGraphic(iv4);

        //Start button after clicking new file
        Button start = new Button("Start");


        //Storing Hbox Button
        buttonCollection.getChildren().add(Load1);
        buttonCollection.getChildren().add(Exit1);
        buttonCollection.getChildren().add(Save1);
        buttonCollection.getChildren().add(New1);

        Popup exit = new Popup();
        Label exitlabel = new Label("Would you like to save before you leave? ");
        ButtonBar exitbuttonBar = new ButtonBar();
        exitlabel.setStyle(" -fx-background-color: Green;");
        exitlabel.setMinWidth(200);
        exitlabel.setMinHeight(200);
        exit.getContent().add(exitlabel);
        Button exitYes = new Button("yes");

        Button exitNo = new Button("no");
        Button exitCancel = new Button("cancel");
        exitbuttonBar.getButtons().addAll(exitYes,exitNo,exitCancel);
        exit.getContent().addAll(exitbuttonBar);
        exitYes.setOnMouseClicked(event ->{getFileChooser(primaryStage); System.exit(0);});
        exitNo.setOnMouseClicked(event -> System.exit(0));
        exitCancel.setOnMouseClicked(event -> exit.hide());
        Exit1.setOnMouseClicked(event -> exit.show(primaryStage));


          Popup saved = new Popup();
          Label label = new Label("Would you like to save?");
          ButtonBar buttonBar = new ButtonBar();
          label.setStyle(" -fx-background-color: Green;");
          label.setMinWidth(200);
          label.setMinHeight(200);
          saved.getContent().add(label);

          Button yesSave = new Button("yes");

          Button noSave = new Button("no");
            buttonBar.getButtons().addAll(yesSave,noSave);
            saved.getContent().add(buttonBar);
//          saved.getContent().add(yesSave);
//          saved.getContent().add(noSave);
        Save1.setOnMouseClicked(event ->saved.show(primaryStage));
        yesSave.setOnMouseClicked(event -> {getFileChooser(primaryStage); saved.hide();});
        noSave.setOnMouseClicked(event -> saved.hide());



        /*  Loading Button functionality */

        Load1.setOnMouseClicked(event -> loadFileChooser(primaryStage));
        //TODO when yesave button is clicked, save file
        //TODO when no save button is clicked, exit the popup



        //adding topBar to Top of borderpane
        root.setTop(topBar);

        //Store the Habox into Topbar
        buttonCollection.setPadding(new Insets(10,15,15,15));
        root.getChildren().add(buttonCollection);

        StackPane bottom = new StackPane();


        Rectangle bottomBar = new Rectangle(0,0,0,50);


        bottomBar.setFill(Color.YELLOW);
        bottomBar.widthProperty().bind(menu.widthProperty());
        bottom.setAlignment(start, Pos.CENTER);
        bottom.getChildren().addAll(bottomBar,start);


        //hbox to hold right side stuff
        GridPane rightside = new GridPane();
        //gridpane to hold letters and guess bar
        GridPane upperRight = new GridPane();

        upperRight.add(right.visual(),0,20);
        upperRight.add(right.makeButtons(), 0 ,60);
        upperRight.setVgap(0.5);

        rightside.add(upperRight,0,0);
        rightside.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");


        //rightside.add(right.visual(),0, 1);
//        rightside.setVgap(5);
      //  rightside.add(right.makeButtons(),0 , 15);
        rightside.setVgap(5);
        rightside.add(right.count(), 0, 50);
        System.out.print(rightside.getRowCount() +"this is the count of the rows");

        //start.setOnMouseClicked(event ->startFunctionality(root, rightside));
        start.setOnMouseClicked(event ->{root.setRight(rightside);});

        //Setting the Left side

        root.setLeft(left.lpane);



       // lowerRight.setPadding(new Insets(10, 0, 10, 5));
//        lowerRight.setAlignment(Pos.BOTTOM_LEFT);
//        right.makeButtons().setAlignment(Pos.CENTER);
//        right.visual().setAlignment(Pos.CENTER);


        //right.visual().setAlignment();


        //Keep it invisible untill button is clicked on
       // bottomBar.setVisible(false);
        //start.setVisible(false);

       // right.setVisible(false);
       // right.makeButtons().setAlignment(Pos.CENTER);
        //right.makeButtons().setAlignment(Pos.CENTER);


        //Event Handling
        New1.setOnMouseClicked(event -> startFunctionality(root,bottom,primaryStage));
      //  New1.setOnMouseClicked(event -> root.setBottom(bottom));


        //TODO create a countdown whenever a button is pressed
      //  root.setAlignment(counter, Pos.CENTER);
//        start.setOnMouseClicked(event ->{root.setRight(right.makeButtons());
//            try {
//                root.setRight(right.visual());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        });

                //start.setOnMouseClicked(event ->  {root.setAlignment(right.makeButtons(), Pos.CENTER_RIGHT); root.setCenter(right.makeButtons()); });

        //if you click on one one of the buttons you cant start over
//        if (right.startButton()== false){
//            start.setDisable(true);
//        }

    //Making buttons pressable
       root.setOnKeyPressed(e ->{
           if (e.getCode()== KeyCode.A){
               right.findButton('a', left, primaryStage);
           }
           else if (e.getCode()== KeyCode.B){
               right.findButton('b', left, primaryStage);
           }
           else if (e.getCode()== KeyCode.C){
               right.findButton('c',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.D){
               right.findButton('d',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.E){
               right.findButton('e',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.F){
               right.findButton('f',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.G){
               right.findButton('g',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.H){
               right.findButton('h',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.I){
               right.findButton('i',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.J){
               right.findButton('j',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.K){
               right.findButton('k',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.L){
               right.findButton('l',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.M){
               right.findButton('m',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.N){
               right.findButton('n',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.O){
               right.findButton('o',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.P){
               right.findButton('p',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.Q){
               right.findButton('q',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.R){
               right.findButton('r',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.S){
               right.findButton('s',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.T){
               right.findButton('t',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.U){
               right.findButton('u',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.V){
               right.findButton('v',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.W){
               right.findButton('w',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.X){
               right.findButton('x',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.Y) {
               right.findButton('y',left, primaryStage);
           }
           else if (e.getCode()== KeyCode.Z) {
               right.findButton('z',left, primaryStage);
           }


       });






        primaryStage.setTitle("Hangman");
        primaryStage.setScene(menu);
        primaryStage.show();
        //popup.show(primaryStage);
    }

    public FileChooser getFileChooser(Stage primaryStage) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showSaveDialog(primaryStage);
        if (selectedFile != null) {
            saveTextToFile(right,selectedFile);

        }
        return fileChooser;
    }
    private void saveTextToFile( Right rightside, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(rightside.guessRemaining);
            for (int i =0; i <26; i++){
                writer.println(rightside.buttons[i].letter);

                if(rightside.buttons[i].clicked){
                    writer.println(rightside.buttons[i].clicked);
                }else{
                    boolean should_write = false;

                    for (int j =0; j < rightside.guesschar.length; j++){
                        if(rightside.guesschar[j].word.getText().charAt(0) == rightside.buttons[i].letter){
                            should_write = rightside.guesschar[j].shadow;
                        }
                    }
                    writer.println(should_write);

                }
            }

            for (int i =0; i <rightside.guesschar.length; i++){
                writer.print(rightside.guesschar[i].word.getText());

            }

            writer.close();
        } catch (IOException ex) {

        }
    }

    private void loadFileChooser(Stage primaryStage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Text Files", "*.txt"),
                new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
                new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
                new ExtensionFilter("All Files", "*.*"));
        File selectedFile = fileChooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            Right result = load(selectedFile);
            if(result == null){
                return;
            }else{
                //Handling a correctly loaded file here!

                //Updating the right object to store the new Right object
                //right = result;
                //Making the right object update the UI
                for(int letter_index = 0; letter_index < right.buttons.length; letter_index ++) {
                    if (right.buttons[letter_index].clicked == true){
                        right.buttons[letter_index].a.setStyle("-fx-background-color: #00ff00");
                    }
                   // right.buttons[letter_index].setClicked(right.buttons[letter_index].clicked);
                }
                right.counts.setText(Integer.toString(right.guessRemaining));
                left.guessLeft =(right.guessRemaining);
                left.buildHang();
            }
        }
        return;
    }
    private Right load(File name) {
        try{
            File file = name;
            Scanner scanner = new Scanner(file);
            String guess = scanner.nextLine();
            right.guessRemaining = Integer.parseInt(guess);
            for (int i =0; i <52; i+=2){
                char character = scanner.nextLine().charAt(0);

                boolean bool = scanner.nextLine().equals("true");
                right.buttons[i / 2].letter= character;
                right.buttons[i / 2].clicked = bool;
            }
            String wordGuess = scanner.nextLine();
            right.guessBar.getChildren().removeAll(right.guessBar.getChildren());
            right.guesschar = new characterBar[wordGuess.length()];

            for (int i =0; i <wordGuess.length(); i++){
                characterBar a = new characterBar(""+wordGuess.charAt(i),wordGuess.charAt(i), false);
                Rectangle line = new Rectangle();
                line.setWidth(5);
                line.setHeight(1);
                a.wordbox.getChildren().add(a.word);


                //a.word.setFill(Color.TRANSPARENT);
                //color of original letter
                for (int x =0; x <26; x++){
                    System.out.println(right.buttons[x].letter + "   " + wordGuess.charAt(i) + "     " + right.buttons[x].clicked);

                    if(right.buttons[x].letter == (wordGuess.charAt(i)) && right.buttons[x].clicked){
                        System.out.println(wordGuess.charAt(i) + "this is the word in the guess bar");
                        a.word.setFill(Color.BLACK);
                        a.shadow = true;    // set that the word has been found
                    }
                }
                if(a.shadow == false){
                    a.word.setFill(Color.TRANSPARENT);
                }




                a.wordbox.setPadding(new Insets(1, 0, 0, 5));
                right.guessBar.add(a.wordbox,i, 1);

                right.guessBar.add(line,i,1);
                right.guesschar[i] = a;



            }


            for (int i =0; i<wordGuess.length(); i++){
                right.guesschar[i].word.setText(""+wordGuess.charAt(i));
            }
            return right;
        }catch(FileNotFoundException error){
            return null;
        }

    }
    public void startFunctionality(BorderPane root,StackPane bottom, Stage primaryStage){
        if (hasStarted == true){
            Popup choose = new Popup();
            Label chooseLabel = new Label("Would you like to save your game??");
            ButtonBar buttonBar = new ButtonBar();

            chooseLabel.setStyle(" -fx-background-color: Green;");
            chooseLabel.setMinWidth(400);
            chooseLabel.setMinHeight(400);
            choose.getContent().add(chooseLabel);

            Button yesChoose = new Button("yes");

            Button noChoose = new Button("no");
            Button cancelChoose = new Button("cancel");
            buttonBar.getButtons().addAll(yesChoose,noChoose, cancelChoose);
            choose.getContent().add(buttonBar);
            choose.show(primaryStage);
           noChoose.setOnMouseClicked(event -> {choose.hide();
               try {
                   resetButtons();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           });//Todo reset the stage


            yesChoose.setOnMouseClicked(event -> getFileChooser(primaryStage));
            cancelChoose.setOnMouseClicked(event -> choose.hide());



        }
        else{
          //  root.setRight(rightside);
            root.setBottom(bottom);
            hasStarted= true;

        }

    }
    public void resetButtons() throws IOException {
        for (int i =0;i <right.buttons.length; i++){
            right.buttons[i].clicked = false;
            right.buttons[i].a.setStyle("-fx-background-color: white");
            right.buttons[i].a.setDisable(false);
        }


        right.guessBar.getChildren().removeAll(right.guessBar.getChildren());

        read read = new read();
        Random rand = new Random();
        read.readLine();//reads how many lines there are in the file

        int max = read.count;

        //TODO fix max
        System.out.println(max + "!!!!!!!!!!!!!!!!!! this is max");

        int n = rand.nextInt(max)-1;


        String ap =read.getLine(n);
        System.out.println(ap + "tacos this is the real character");

        right.guesschar = new characterBar[ap.length()];



        for (int i =0; i <ap.length(); i++){
            characterBar a = new characterBar(""+ap.charAt(i),ap.charAt(i), false);
            Rectangle line = new Rectangle();
            line.setWidth(5);
            line.setHeight(1);
            a.wordbox.getChildren().add(a.word);

            //color of original letters
            a.word.setFill(Color.TRANSPARENT);


            a.wordbox.setPadding(new Insets(1, 0, 0, 5));
            right.guessBar.add(a.wordbox,i, 1);

            right.guessBar.add(line,i,1);
            right.guesschar[i] = a;



        }



        right.counts.setText(Integer.toString(10));
        right.guessRemaining = 10;
        left.guessLeft =10;
        left.buildHang();
    }


    public void setUp(){
        for(int letter_index = 0; letter_index < right.buttons.length; letter_index ++) {
            if (right.buttons[letter_index].clicked == true){
                right.buttons[letter_index].a.setStyle("-fx-background-color: white");
            }
            // right.buttons[letter_index].setClicked(right.buttons[letter_index].clicked);

        }
        right.counts.setText(Integer.toString(right.guessRemaining));

        left.guessLeft =10;
        left.buildHang();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
