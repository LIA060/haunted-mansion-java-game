package org.uob.a1.gameobjects;
import java.util.HashMap;

public class Room {


    private String name;
    private String description;
    private Item [] items; //array with S
    private Npc [] npcs;
    private HashMap<String, Exit> exit;

    public Room(String name, String description) {
        // TODO
        this.name = name;
        this.description = description;

        items = new Item[0];
        npcs = new Npc[0];
        exit = new HashMap<String, Exit>();
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public Item [] getItems() {
        return items;
    }
    public Npc [] getNpcs() {
        return npcs;
    }
    public HashMap<String, Exit> getExit() {
        return exit;
    }

    public Exit getExit(String name) {
        return exit.get(name.toLowerCase());
    }

    public String toString() {
        String result = name + ": " + description + "\n\n";

        result = result + "Exits: ";
        for (String exitName : exit.keySet()) {
            result = result + exitName + " ";
        }

        result = result + "\nNPCs: ";
        for(int i=0; i<npcs.length; i++){
            result = result + npcs[i].getName() + " ";
        }

        result = result + "\nItems: ";
        for(int i=0; i<items.length; i++){
            result = result + items[i].getName() + " ";
        }
        
        return result;
    }

    public void addExit(Exit exit) {
        // TODO
        this.exit.put(exit.getName().toLowerCase(), exit);
        
    }

    public void addItem(Item item) { //the one in player
        // TODO
        Item [] n = new Item[items.length +1]; 

        for(int i=0; i<items.length; i++){
            n[i] = items[i];
        }
        n[items.length] = item;
        items = n; 
    }

    public void addNpc(Npc npc) {
        // TODO
        Npc [] n = new Npc[npcs.length +1];

        for(int i=0; i< npcs.length; i++){
            n[i] = npcs[i];
        }
        n[npcs.length] = npc;
        npcs = n;
    }

    public void removeItem(Item item) {

        String target = item.getName().toLowerCase();

        int count = 0; //count how many items are there
        for(int i=0; i<items.length; i++){
            if(items[i].getName().toLowerCase().equals(target)){
                count++;
            }
        }

        if (count == 0 ){ //if none, none are taken
            return;
        }

        Item [] n = new Item[items.length - count]; //if something is taken we create the new array of objects 

        int j = 0;
        for(int i=0; i<items.length; i++){
            if(!items[i].getName().toLowerCase().equals(target)){
                n[j] = items[i];
                j++;
            }
        }
        items = n;
    }
}
