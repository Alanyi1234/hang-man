package sample;
import javafx.geometry.Insets;
import javafx.stage.Popup;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import sample.Letter;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javax.swing.*;
import java.io.Serializable;
import java.util.Random;

import java.io.IOException;

public class Right extends GridPane implements Serializable {
    int guessRemaining = 10;
   // String a = " ";
   // counter guess = new counter(10);
    String alphabet = "abcdefghijklmnopqrstuvwxyz" ;
    GridPane StoreLetter = new GridPane();
    Letter [] buttons = new Letter[26];
    GridPane guessBar = new GridPane();
    read read = new read();
    Pane counter = new Pane();
    Text counts = new Text();
    characterBar[] guesschar= new characterBar[read.count];
    String actualword="";




    //have guessBar appear above the make buttons

    public Pane count(){
        counts = new Text(""+guessRemaining);
        counts.setFont(Font.font ("Verdana", 100));
        counter.getChildren().addAll(counts);
        return counter;

    }
    public GridPane visual() throws IOException {
        Random rand = new Random();
        read.readLine();//reads how many lines there are in the file
        int max = read.count;
        //TODO fix max
        System.out.println(max + "!!!!!!!!!!!!!!!!!! this is max");

        int random = (int) Math.random()* 10 + 1;
        int n = rand.nextInt(max)-1;

        System.out.print(n + "this is the random number");

        String ap =read.getLine(n);
        actualword = ap;
        System.out.println(ap + "!!!!!!!!!!!!!!!!!!!!!!");
        guesschar = new characterBar[ap.length()];
        VBox temp= new VBox();


        for (int i =0; i <ap.length(); i++){
//            Pane wordbox = new Pane();
//            Text word = new Text(""+read.word.charAt(i));
            characterBar a = new characterBar(""+ap.charAt(i),ap.charAt(i), false);
            Rectangle line = new Rectangle();
            line.setWidth(5);
            line.setHeight(1);



            a.wordbox.getChildren().add(a.word);


            //color of original letters
            a.word.setFill(Color.TRANSPARENT);


            a.wordbox.setPadding(new Insets(1, 0, 0, 5));
            guessBar.add(a.wordbox,i, 1);

            guessBar.add(line,i,1);
            guesschar[i] = a;



        }
//        stack.getChildren().add(guessBar);
//        guessBar.setAlignment(Pos.CENTER);

        return guessBar;
    }

    public GridPane makeButtons(){

        for (int i =0; i < 26; i++) {
            int row = i / 7;
            int col = i % 7;
            Letter letter = new Letter(false, alphabet.charAt(i));

            letter.a.setMinWidth(30);

            letter.a.setText(letter.getLetter() + "");
            StoreLetter.add(letter.a, col, row);

            buttons[i] = letter;

        }
        return StoreLetter;

    }



    public void findButton (char a, Left b, Stage stage) {

        Button saveButton = (Button)stage.getScene().lookup("#SaveButton");
        saveButton.setDisable(false);


        boolean temp = false;
        for (int i = 0; i < 26; i++) {
            if (buttons[i].letter == a) {
               // buttons[i].clicked = true;
                if (buttons[i].a.isDisable() == false) {
                    buttons[i].a.setDisable(true);
                    buttons[i].a.setStyle("-fx-background-color: #00ff00");
                    System.out.println("made into if");

                    for (int j = 0; j < guesschar.length; j++) {
                        //System.out.println(j+ "in the for loop");
                        System.out.println(a);

                        char barLetter = guesschar[j].z;
                        System.out.println(barLetter + "this is the word in the guess bar");


                        //if letter exists in guessbar, otherwise decrement the guess
                        if (barLetter == (a)) {
                            temp = true;
                            System.out.println(guesschar[j].z + "this is the word in the guess bar");

                            guesschar[j].word.setFill(Color.BLACK);
                            guesschar[j].shadow = true;    // set that the word has been found

                        }

                        //error here with logic, if letter is not a, will continue loop and decrement

                    }
                    if(temp == false){
                        System.out.print("inside else if");
                        buttons[i].clicked = true;
                        if (guessRemaining >=1) {
                            guessRemaining--;

                            counts.setFill(Color.TRANSPARENT);
                            counts = new Text("" + guessRemaining);
                            counts.setFont(Font.font("Verdana", 100));
                            b.guessLeft = guessRemaining;

                            b.buildHang();


                            //TODO link to Left to print pictures of hangman
                            //TODO example: left(guessremaining) takes in the number, and if statements/switch to print the character

                        } else {
                            System.out.print("ending game");
                            Popup test = new Popup();
                            Label lost = new Label("Game over"+"\n"
                            + "the word is: " +actualword );
                            lost.setStyle(" -fx-background-color: grey;");
                            lost.setMinWidth(200);
                            lost.setMinHeight(200);
                            test.getContent().add(lost);
                            test.show(stage);
//
                            Button close = new Button("close");
                            test.getContent().add(close);
                            close.setOnMouseClicked(event -> test.hide());

//                            Button noChoose = new Button("no");
//                            Button cancelChoose = new Button("cancel");
//                            buttonBar.getButtons().addAll(yesChoose,noChoose, cancelChoose);
//                            choose.getContent().add(buttonBar);
//                            choose.show(primaryStage);



                            break;
                            //TODO end the game disable all buttons, and make popup occur
                        }
                        //  counter.getChildren().removeAll();
                        counter.getChildren().addAll(counts);



                        //add a picture to hangman
                        break;
                    }
                    System.out.println("pressed" + buttons[i].letter);


                }
                break;
                //check to see if it exists in guesschar


            }

        }

    }


}

