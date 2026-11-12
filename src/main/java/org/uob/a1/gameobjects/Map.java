package org.uob.a1.gameobjects;

public class Map {

    private Player p;
    private Room currentRoom;
    private Score s;
    private boolean running;

    //extra for hidden key
    private Room bedroom;
    private Item key;
    private boolean keyfound;

    public Map(Room startingRoom){
        this.currentRoom = startingRoom;
        this.p = new Player();
        this.s = new Score();
        this.running = true;
    }
    public Map() {
        // set up the rooms based on map/layout.txt
        this.p = new Player();
        this.s = new Score();
        this.running = true;
        this.keyfound = false;
       

        Room r0 = new Room("\nroom 0: entrance", "a dusty entrance hall with a staircase and two mysterious doors infront. The heavy front door mysteriously shut, leaving you trapped");
        Room r1 = new Room("\nroom 1: library", "an old library filled with old books and broken furniture... and a strange loud silence filling the room");
        Room r2 = new Room("\nroom 2: dining room", "a large dining room where chairs are scattered around and a strange noise seems to come from somewhere nearby");
        Room r3 = new Room("\nroom 3: portrail gallery", "a gallery filled with paintings of the mansion's previous owners. A ghost wanders between the portraits, looks like he knows something about escaping");
        Room r4 = new Room("\nroom 4: old bedroom", "a bedroom with a big bed and a wooden old wardrobe. \n There are scartches around the wardrobe.. as if someone had searched it before.");
        Room r5 = new Room("\nroom 5: secret escape tunnel", "a hidden stone chamber leading to an underground escape tunnel. Entrance is sealed by an old locked door.. the only way out of the mansion");

        this.currentRoom = r0;
        this.bedroom = r4;

        Exit e1 = new Exit("north", r2, false);
        e1.setSource(r0);
        r0.addExit(e1);

        Exit e2 = new Exit("east", r1, false);
        e2.setSource(r0);
        r0.addExit(e2);

        Exit e3 = new Exit("south", r2, false);
        e3.setSource(r1);
        r1.addExit(e3);

        Exit e4 = new Exit("east", r3, false);
        e4.setSource(r1);
        r1.addExit(e4);

        Exit e5 = new Exit("west", r0, false);
        e5.setSource(r1);
        r1.addExit(e5);

        Exit e6 = new Exit("north", r1, false);
        e6.setSource(r2);
        r2.addExit(e6);

        Exit e7 = new Exit("south", r0, false);
        e7.setSource(r2);
        r2.addExit(e7);

        Exit e8 = new Exit("east", r3, false);
        e8.setSource(r2);
        r2.addExit(e8);

        Exit e9 = new Exit("north", r1, false);
        e9.setSource(r3);
        r3.addExit(e9);

        Exit e10 = new Exit("east", r4, false);
        e10.setSource(r3);
        r3.addExit(e10);

        Exit e11 = new Exit("west", r2, false);
        e11.setSource(r3);
        r3.addExit(e11);

        Exit e12 = new Exit("east", r5, true);
        e12.setSource(r4);
        r4.addExit(e12);

        Exit e13 = new Exit("west", r3, false);
        e13.setSource(r4);
        r4.addExit(e13);

        Exit e14 = new Exit("west", r4, false);
        e14.setSource(r5);
        r5.addExit(e14);

        Npc servant = new Npc("servant", "PLEASE, you must listen!! this mansion is not safe, fron doors are sealed, and the only way out is through the secret tunnel.\n You need to find the key hidden somewhere. Be careful, something is watching you...");
        Npc ghost = new Npc("ghost", "Ah... another visitor. What is it that you wish to know? \n\n"+ "1. What happened to the previous owner?\n"+"2. Where can I find the escape key?\n"+"Type 'ask 1' or 'ask 2' to choose your question\n");

        r0.addNpc(servant);
        r3.addNpc(ghost);


        
        Item key = new Item("key", "an old, rusty key. It kind of looks improtant..", r4, "you hear a CLICK!! the bedroom key unlocked the escape tunnel", "key", e12);
        Item torch = new Item("torch", "an old torch covered in dust", r2, "you examine the old torch", "torch", null);
        Item journal = new Item("journal", "an old leather journal that feels like its calling your name..\n You open the first page.. 'I can hear the screamings.. they are disappearing one by one.\n Something is hiding inside the mansion..i dont think any of us can escape.'\n THATS IT! The journal is making the air too creepy, no more reading.", r1,"you quickly but carefully close the journal", "journal", null);


        
        r4.addItem(key);
        r2.addItem(torch);
        r1.addItem(journal);

    }

    public boolean revealKey(){
        if(keyfound == false){
            bedroom.addItem(key);
            keyfound = true;
            return true;
        }
        return false;
    }

    public void displayMap(){

        System.out.println();
        System.out.println("                      HAUNTED MANSION");
        System.out.println();

        System.out.println("  +------+     +-------+     +------+      +------+");

        System.out.println("  |  R2  |-----|  R3   |-----|  R4   |-----|  R5  |");

        System.out.println("  |Dining|     |Gallery|     |Bedroom|     |Escape|");

        System.out.println("  +------+     +-------+     +------+      +------+");

        System.out.println("      |             |  ");

        System.out.println("      |             |   ");

        System.out.println("  +------+       +------+     ");

        System.out.println("  |  R0    |-----|  R1   |");

        System.out.println("  |Entrance|     |Library| ");

        System.out.println("  +-------+      +------+");
        
        System.out.println();
        System.out.println("ADDITIONAL CONNECTION");
        System.out.println("R1 SOUTH --> R2");
        System.out.println("R2 NORTH --> R1");
        System.out.println("R1 EAST  --> R3");
        System.out.println("R3 NORTH --> R1");
       

        System.out.println();
        System.out.println("R0 is the starting room");
        System.out.println("R5 loacked escape room");


    }

    public Player getPlayer() {
        return p;
    }

    public Score getScore() {
        return s;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;

    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }



}
