package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
public class counter extends Label {
    public Label counter;


    public Label getCounter() {
        return counter;
    }


    public int startingNumber;
    public counter(int a ){
        startingNumber = a;
    }

    public void pressButton(ActionEvent actionEvent) {
        counter.setText(addOne());     // prints the updated number
    }

    private String addOne() {
        startingNumber -= 1;
        return Integer.toString(startingNumber);
    }
}
