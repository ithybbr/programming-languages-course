package actors;

import inventory.Inventory;

abstract public class Actor {
    private Inventory inventory;
    public Actor(Inventory inventory){
        this.inventory = inventory;
    }
    public String toString(){
        return inventory.toString() + "\n";
    }
}
