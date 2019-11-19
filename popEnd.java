package sample;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.Button;


import java.awt.*;

public class popEnd {
    Popup a = new Popup();
    Button close = new Button("Quit");
    Label won = new Label("You own");
   // Text uwon = new Text("u won");

    public Popup buildEnd(Stage stage){

        won.setStyle(" -fx-background-color: black;");
        won.setMinWidth(80);
        won.setMinHeight(50);

        a.getContent().add(won);
        a.getContent().add(close);


      //  a.getContent().add(uwon);
        a.show(stage);
       // a.getContent().add(close);
        return a;
    }
}
