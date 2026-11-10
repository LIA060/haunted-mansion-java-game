package org.uob.a1.gameobjects;

public class Npc {

    private String name;
    private String dialogue;


    public Npc(String name, String dialogue) {
        // TODO
        this.name = name;
        this.dialogue = dialogue;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDialogue() {
        return dialogue;
    }
    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }
}
