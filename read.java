package sample;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class read {
    String word ="";
    int count = 0;


    public void readLine() throws IOException {
        //BufferedReader reader = new BufferedReader(new FileReader("sample/words.txt"));
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);


        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
            count ++;
        }



    }
    public String getLine(int a) throws IOException {
        int temp =0;
        File file = new File("words.txt");
        Scanner scanner = new Scanner(file);
        String result ="";


        while(temp != a-1){
            System.out.println();
            System.out.println( ""+ temp +"this is temp");
            System.out.print(a +"this is a");
            System.out.print(scanner.nextLine());




            temp ++;

        }
      //  System.out.print(a +"this is the guessed number");
        result = scanner.nextLine();
       // word = scanner.nextLine();
        return result  ;

    }


}
