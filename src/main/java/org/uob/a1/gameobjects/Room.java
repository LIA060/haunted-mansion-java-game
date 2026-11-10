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

    public void addExit(Exit exit) {
        // TODO
        
    }

    public void addItem(Item item) {
        // TODO
        Item [] n = new Item[items.length +1]; //the one in player

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
}
