package actors;

import inventory.Inventory;

public class Player extends Actor{
    private Inventory inventory;
    public Player(Inventory inventory){
        super(inventory);
        this.inventory = inventory;
    }
    public String toString(){
        return "Player " + inventory.toString();
    }
}
