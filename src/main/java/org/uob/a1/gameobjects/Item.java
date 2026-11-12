package org.uob.a1.gameobjects;

public class Item {

    private String name;
    private String description;
    private Room usedIn;
    private String usedText;
    private String type;
    private Object target;


    public Item(String name, String description, Room usedIn, String usedText, String type, Object target) {//
        this.name = name;
        this.description = description;
        this.usedIn = usedIn;
        this.usedText = usedText;
        this.type = type;
        this.target = target;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Room getUsedIn() {
        return usedIn;
    }
    public void setUsedIn(Room usedIn) {
        this.usedIn = usedIn;
    }

    public String getUsedText() {
        return usedText;
    }
    public void setUsedText(String usedText) {
        this.usedText = usedText;  
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Object getTarget() {
        return target;
    }
    public void setTarget(Object target) {
        this.target = target;
    }
}
