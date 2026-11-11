package org.uob.a1.parser;

import org.uob.a1.gameobjects.Map;
import org.uob.a1.gameobjects.Room;
import org.uob.a1.gameobjects.Exit;
import org.uob.a1.gameobjects.Item;
import org.uob.a1.gameobjects.Npc;

public class Parser {

    public Parser() {}

    public String parse(Map map, String input) {
        // work out which command was entered, execute it and return the result

        if(input == null || input.length() == 0){
            return "please enter a command";
        }

        input = input.toLowerCase(); //switching everything to lower case to make it readable 

        while(input.length()>0 && input.charAt(0) == ' '){  //spaces at the start
            input = input.substring(1);
        }

        while(input.length()>0 && input.charAt(input.length()-1) == ' '){  //spaces at the end
            input = input.substring(1);
        }

        int space = input.indexOf(" "); //we look for any spaces in the input
        String word1;
        String word2;

        if(space == -1){ //if no space was found 
            word1 = input ;
            word2 = "";
        }
        else{
            word1 = input.substring(0, space);
            word2 = input.substring(space+1);

            while(word2.length()>0 && word2.charAt(0) == ' '){ //spaces between two words
                word2 = word2.substring(1);
            }
        }
        


        switch (word1){

            //1) move
            case "move":
                if(word2.equals("")){
                    return "please choose a direction";
                }
                Exit exit = map.getCurrentRoom().getExit(word2);
                if(exit == null){
                    return "you cant go that way";
                }
                if(exit.isLocked()){
                    return "the way is locked";
                }
                map.setCurrentRoom(exit.getDestination());
                return map.getCurrentRoom().toString();

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
