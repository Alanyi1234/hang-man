package sample;
import javafx.scene.control.Button;
import java.awt.*;
import java.io.Serializable;

public class Letter implements Serializable {

    Button a = new Button();



    boolean clicked ;
    char letter ;


    public Letter(){
        clicked = false;
        letter = ' ';
    }
    public Letter(boolean a, char b){
        clicked = a;
        letter = b;

    }

    public char getLetter(){
        return letter;
    }
    public void setLetter(char a ){
        letter = a;
    }
    public boolean getClicked(){
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
}
