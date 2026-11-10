package org.uob.a1;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO: start the game and keep requesting user input until they quit

        Scanner sc = new Scanner(System.in);

       
        System.out.println("Welcome to the Haunted Mansion!");

        System.out.println("Type 'quit' to exit the game.");

        String input = "";
        while(!input.equals("quit")){
            System.out.println("start the game by typing an input");
            input = sc.nextLine();

        }
        System.out.println("Thanks for playing!");
            


    }
}
