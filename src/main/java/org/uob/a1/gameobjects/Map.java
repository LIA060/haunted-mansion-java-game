package org.uob.a1.gameobjects;

public class Map {

    private Player p;
    private Room currentRoom;
    private Score s;
    private boolean running;


    public Map(Room startingRoom) {
        // TODO
        this.currentRoom = startingRoom;
        this.running = true;
    }

    public Map() {
        // TODO: set up the rooms based on map/layout.txt
    }

    public boolean isRunning() {
        // TODO
        return running;
    }

    public void setRunning(boolean running) {
        // TODO
        this.running = running;

    }

    public Room getCurrentRoom() {
        // TODO
        return currentRoom;
    }
}
