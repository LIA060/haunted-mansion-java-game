package org.uob.a1.gameobjects;

public class Exit {

    private String name;
    private Room destination;
    private Room source;
    private boolean locked;
    private Item key;


    public Exit(String name, Room destination, boolean locked) {
        // TODO
        this.name = name;
        this.destination = destination;
        this.locked = locked;

        this.source = null;
        this.key = null;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Room getDestination() {
        return destination;
    }
    public void setDestination(Room destination) {
        this.destination = destination;
    }
    
    public Room getSource() {
        return source;
    }
    public void setSource(Room source) {
        this.source = source;
    }

    public boolean isLocked() {
        return locked;
    }
    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public Item getKey() {
        return key;
    }
    public void setKey(Item key) {
        this.key = key;
    }
}
