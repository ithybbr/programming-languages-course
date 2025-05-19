package actors;

import inventory.Inventory;

public class Enemy extends Actor{
    private static int nextId = 1;
    private int id;
    private Inventory inventory;
    public Enemy(Inventory inventory){
        super(inventory);
        this.inventory = inventory;
        id = nextId++;
    }
    public String toString(){
        return "Enemy " + id + " " + inventory.toString();
    }
}
