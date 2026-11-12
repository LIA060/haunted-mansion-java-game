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
        while(input.length()>0 && input.charAt(input.length()-1) == ' '){ //spaces at the end
            input = input.substring(0, input.length()-1);
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

            while(word2.length()>0 && word2.charAt(word2.length()-1) == ' '){ //spaces at the end of the second word
                word2 = word2.substring(0, word2.length()-1);
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
                if(map.getCurrentRoom().getName().equals("room 5: secret escape tunnel")){
                    map.setRunning(false);
                    return "YOU ESCAPED!!!\n Congratulations!! the fresh wind touching your face must feel amazing.\n Final scor: "+ map.getScore().getScore();
                }
                map.getScore().updatemove();

                return "you moved " +word2;

            //2) look
            case "look":
                if(word2.equals("")){
                    return map.getCurrentRoom().toString();
                }
                //wardrobe
                if(word2.equals("wardrobe")){
                    if(map.getCurrentRoom().getName().equals("bedroom")){
                        if(map.revealKey()){
                            return "you open the wardrobe and look through the dusty clothes.. theres a a rusty key!!";
                        } 
                        else{
                            return "you already checked the wardrobe";
                        }
                    } 
                    else{
                        return "the wardrobe is not here";
                    }
                }

                //bed
                if(word2.equals("wardrobe")){
                    if(map.getCurrentRoom().getName().equals("bedroom")){
                        return "you slowly look around and under the bed. \nAHHH! EW a large rat just ran from under the bed... theres nothing else tho";
                    }
                    else{
                        return "the bed is not here";
                    }
                }
               

                Item [] item = map.getCurrentRoom().getItems();
                for(int i=0; i<item.length; i++){
                    if(item[i].getName().toLowerCase().equals(word2.toLowerCase())){ ////or you can use helper method?
                        return item[i].getDescription();
                    }
                }
                return "you cant see that here ";
            
            //3 take
            case "take":
                if(word2.equals("")){
                    return "specify the item";
                }
                Item [] rItems = map.getCurrentRoom().getItems();
                for(int i=0; i<rItems.length; i++){
                    if(rItems[i].getName().toLowerCase().equals(word2.toLowerCase())){
                        map.getPlayer().addItem(rItems[i]); //add the item to inventory
                        map.getCurrentRoom().removeItem(rItems[i]); //remove the item from the room
                        return "you took the " +word2; 
                    }
                }
                return "not found, choose different item ";
            //ask
            case "ask":
                if(word2.equals("1")){
                    return "The previous owner vanished many years ago, "
                    + "under disturbing circumstances. \nAll that was left of them was traces of their blood! "
                    +"Not even their bodies were found... Some say they never really left";
                }
                else if(word2.equals("2")){
                    return "Everyone wants to know where it is, but no one knows.. "
                    +"\nThe previous owner left their most precious belongings in the bedroom."
                    +" Search carefully around the bed and wardrobe.. the key is closer than you think..";
                }
                else{
                    return "please ask a question";
                }
            //3 get
            case "get":
                if(word2.equals("")){
                    return "specify the item";
                }
                Item [] RItems = map.getCurrentRoom().getItems();
                for(int i=0; i<RItems.length; i++){
                    if(RItems[i].getName().toLowerCase().equals(word2.toLowerCase())){
                        map.getPlayer().addItem(RItems[i]); //add the item to inventory
                        map.getCurrentRoom().removeItem(RItems[i]); //remove the item from the room
                        return "you took the " +word2; 
                    }
                }
                return "not found, choose different item ";
            //4 inventory
            case "inventory":
                Item [] inventory = map.getPlayer().getInventory(); //getting the inventory 
                if(inventory.length == 0){
                    return "you have no items in your inventory";
                }
                String result = "your inventory: ";
                for(int i=0; i<inventory.length; i++){ //printing the array
                    result = result + inventory[i].getName() + " ";
                }
                return result;
            //5 use
            case "use":
                if(word2.equals("")){
                    return "specify the item";
                }
                Item [] inv = map.getPlayer().getInventory();
                for(int i=0; i<inv.length; i++){
                    if(inv[i].getName().toLowerCase().equals(word2.toLowerCase())){

                        if("key".equals(inv[i].getType()) && inv[i].getTarget()!= null){

                            if(inv[i].getUsedIn() != map.getCurrentRoom()){ //incase the key was used in a different room from r4
                                return "u cant use this here ";
                            }

                           Exit target = (Exit) inv[i].getTarget();
                           if(target.isLocked()){
                            target.setLocked(false);
                            map.getScore().updateunlock();
                            return inv[i].getUsedText();
                           }
                           else{
                            return "the exit is already unlocked";
                           }
                        }
                        else{
                            return "you cant use this item";
                        }
                    }
                }
                return "u don thave this item " ;
            //6 activate 
            case "activate":
                if(word2.equals("")){
                    return "specify the item";
                }
                Item [] inv1 = map.getPlayer().getInventory();
                for(int i=0; i<inv1.length; i++){
                    if(inv1[i].getName().toLowerCase().equals(word2.toLowerCase())){

                        if("key".equals(inv1[i].getType()) && inv1[i].getTarget()!= null){

                            if(inv1[i].getUsedIn() != map.getCurrentRoom()){ //incase the key was used in a different room from r4
                                return "u cant use this here ";
                            }
                           Exit target = (Exit) inv1[i].getTarget();
                           if(target.isLocked()){
                            target.setLocked(false);
                            map.getScore().updateunlock();
                            return inv1[i].getUsedText();
                           }
                           else{
                            return "the exit is already unlocked";
                           }
                        }
                        else{
                            return "you cant use this item";
                        }
                    }
                }
                return "u don thave this item " ;
            // talk
            case "talk":
                if(word2.equals("") || word2.equals("to")){
                    return "specify who you wanna talk to";
                }
                if(word2.length() >= 3 && word2.substring(0,3).equals("to ")){
                    word2 = word2.substring(3);
                    //just incase theres more spcae
                    while(word2.length()>0 && word2.charAt(0) == ' '){
                        word2=word2.substring(1);
                    }
                }
                Npc [] npcs = map.getCurrentRoom().getNpcs();
                for(int i=0; i<npcs.length; i++){
                    if(npcs[i].getName().toLowerCase().equals(word2.toLowerCase())){
                        return npcs[i].getDialogue();
                    }
                }
                return "NPC not found ";
            //score
            case "score":
                return "your score: " +map.getScore().getScore();
            //help
            case "help":
                return "Choose what to do (move, look, take, get, inventory, use, activate, talk, score, map) or type quit/exit";
            //quit
            case "quit":
                map.setRunning(false);
                return "quitting game";
            //exit
            case "exit":
                map.setRunning(false);
                return "exiting game";
            //map
            case "map":
                if(word1.equals("map")){
                    map.displayMap();
                    return "here is the mansion";
                }
            default:
                return "write help for assistance";

    

                 
        }
        
    }
}
