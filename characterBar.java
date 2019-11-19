package sample;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.awt.*;

public class characterBar {
    VBox box = new VBox();
    Pane wordbox = new Pane();

    Text word;
    boolean shadow;
    char z;

    public characterBar(String a,char b, boolean c){
        word = new Text(a);
        z = b;
        shadow = c;
        //TODO make module store stuff from visual into characterBar and make array.
        //TODO then make it so when button is pressed unshade color from pane to reveal character
    }


}
