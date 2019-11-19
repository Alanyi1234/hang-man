package sample;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.*;
import javafx.scene.*;


public class Left {
    int guessLeft ;
    Image nine = new Image("nine.png");
    ImageView nine1 = new ImageView();

    Image eight = new Image("eight.png");
    ImageView eight1 = new ImageView();

    Image seven = new Image("seven.png");
    ImageView seven1 = new ImageView();

    Image six = new Image("six.png");
    ImageView six1 = new ImageView();


    Image five = new Image("five.png");
    ImageView five1 = new ImageView();

    Image four = new Image("four.png");
    ImageView four1 = new ImageView();

    Image three = new Image("three.png");
    ImageView three1 = new ImageView();

    Image two = new Image("two.png");
    ImageView two1 = new ImageView();

    Image one = new Image("one.png");
    ImageView one1 = new ImageView();

    Image zero = new Image("zero.png");
    ImageView zero1 = new ImageView();
    GridPane lpane = new GridPane();
    public Left(){

    }

    public Left (int a){
        guessLeft =a;
    }

    public void buildHang() {
        switch (guessLeft) {
            case 0:
                lpane.getChildren().remove(one1);
                zero1.setImage(zero);
                lpane.setVgap(10);
                lpane.add(zero1, 1, 3);

                break;
            case 1:
                lpane.getChildren().remove(two1);
                one1.setImage(one);
                lpane.setVgap(10);
                lpane.add(one1, 1, 3);


                break;
            case 2:
                lpane.getChildren().remove(three1);
                two1.setImage(two);
                lpane.setVgap(10);
                lpane.add(two1, 1, 3);

                break;
            case 3:
                lpane.getChildren().remove(four1);
                three1.setImage(three);
                lpane.setVgap(10);
                lpane.add(three1, 1, 3);

                break;
            case 4:
                lpane.getChildren().remove(five1);
                four1.setImage(four);
                lpane.setVgap(10);
                lpane.add(four1, 1, 3);

                break;
            case 5:
                lpane.getChildren().remove(six1);
                five1.setImage(five);
                lpane.setVgap(10);
                lpane.add(five1, 1, 3);

                break;
            case 6:
                lpane.getChildren().remove(seven1);
                six1.setImage(six);
                lpane.setVgap(10);
                lpane.add(six1, 1, 3);
                break;
            case 7:
                lpane.getChildren().remove(eight1);
                seven1.setImage(seven);
                lpane.setVgap(10);
                lpane.add(seven1, 1, 3);
                break;
            case 8:
               // lpane.getChildren().remove(nine)
                lpane.getChildren().remove(nine1);
                eight1.setImage(eight);
                lpane.setVgap(10);
                lpane.add(eight1, 1, 3);
                System.out.print("made into switch");

                break;
            case 9:

                nine1.setImage(nine);
                lpane.setVgap(10);
                lpane.add(nine1, 2, 3);
                System.out.print("made into switch");

                break;
            case 10:
                lpane.getChildren().removeAll(eight1, seven1,six1,five1,four1,three1,two1,one1, nine1, zero1);
                break;
        }
    }
}
