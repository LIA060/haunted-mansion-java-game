package org.uob.a1.gameobjects;

public class Player {

    private Item [] inventory;

    public Player(){
        inventory = new Item[0]; 
    }

    public void addItem( Item item){
        Item [] n = new Item[inventory.length +1]; //so the player doesnt lose any items

        for(int i=0; i<inventory.length; i++){
            n[i] = inventory[i];
        }
        n[inventory.length] = item; //the new item added
        inventory = n;
    }

    public Item [] getInventory(){
        return inventory;
    }

    public Item getItem(String name){
        for (int i=0; i<inventory.length; i++){
            if(inventory[i].getName().toLowerCase().equals(name.toLowerCase())){
                return inventory[i];
            }
        }
        return null;
    }

    public void displayInventory(){
        if(inventory.length == 0){
            System.out.println("You have no items in your inventory.");
        }
        else{
           for(int i=0; i<inventory.length; i++){
            System.out.println(inventory[i].getName());
        }
        }
        
    }
}
