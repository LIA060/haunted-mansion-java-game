package org.uob.a1;
import java.util.Scanner;
import org.uob.a1.gameobjects.Map;
import org.uob.a1.parser.Parser;

public class Main {

    public static void main(String[] args) {
       

        Scanner sc = new Scanner(System.in);

        Map m = new Map();
        Parser p = new Parser();


       
        System.out.println("Welcome to the Haunted Mansion!\n");
        m.displayMap();

        while(m.isRunning()){
            System.out.println(m.getCurrentRoom());
            System.out.println("> ");
            String input = sc.nextLine();
            String res = p.parse(m, input);
            System.out.println(res);
        }
            


    }
}
