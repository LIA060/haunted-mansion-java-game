package org.uob.a1.parser;

import org.uob.a1.gameobjects.Map;

public class Parser {

    public Parser() {}

    public String parse(Map map, String input) {
        // TODO: work out which command was entered, execute it and return the result
        if(input == null || input.length() == 0){
            return "please enter a command";
        }

        input = input.toLowerCase(); //switching everything to lower case to make it readable 

        int space = input.indexOf(" "); //we look for any spaces in the input

        String word1;
        String word2;

        if(space == -1){ //if no space was found 
            word1 = input ;
            word2 = null; // is this allowed? or is "" 
        }
        else{
            word1 = input.substring(0, space);
            word2 = input.substring(space+1);
        }
        //think of any possible errors

        switch (word1){

            //1) move
            case "move":
                if(word2.equals("")){
                    return "please choose a direction";
                }
                return "move: " +word2;

            //2) look
            case "look":
                if(word2.equals("")){
                    return "looking....";
                }
                return "looking for: " +word2;
            
            //3 take
            case "take":
                if(word2.equals("")){
                    return "specify the item";
                }
                return "taking: " +word2;
            //3 get
            case "get":
                if(word2.equals("")){
                    return "specify the item";
                }
                return "getting: " +word2;
            //4 invent
            case "inventory":
                return "view inventory";
            //5 use
            case "use":
                if(word2.equals("")){
                    return "specify the item";
                }
                return "using: " +word2;
            //6 activate 
            case "activate":
                if(word2.equals("")){
                    return "specify the item";
                }
                return "activating: " +word2;
            // talk
            case "talk":
                if(word2.equals("")){
                    return "specify of you wanna talk to";
                }
                if(word2.length() >= 3 && word2.substring(0,3).equals("to ")){
                    word2 = word2.substring(3);
                }
                return "talking to: " +word2;
            //score
            case "score":
                return "display score";
            //help
            case "help":
                return "Choose what to do (move, look, take, get, inventory, use, activate) or type quit";
            //quit
            case "quit":
                return "quitting game";
            //exit
            case "exit":
                return "exiting game";
            default:
                return "write help for assistance";

    

                 
        }
        
    }
}
