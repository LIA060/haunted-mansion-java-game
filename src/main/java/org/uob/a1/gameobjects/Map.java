package org.uob.a1.gameobjects;

public class Map {

    private Player p;
    private Room currentRoom;
    private Score s;
    private boolean running;

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
       

        Room r0 = new Room("room 0", "Starting room");
        Room r1 = new Room("room 1", "2nd room");
        Room r2 = new Room("room 2", "3rd room");
        Room r3 = new Room("room 3", "4rth room");
        Room r4 = new Room("room 4", "5th room");
        Room r5 = new Room("room 5", "6th room");

        this.currentRoom = r0;

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
