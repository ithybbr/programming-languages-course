package game;

import java.util.ArrayList;

import actors.Actor;
import inventory.Inventory;

public class Room {
    private ArrayList<Actor> Actors = new ArrayList<>();
    private Inventory inventory = new Inventory();
    private int i;
    private int j;
    public Room(int i, int j){
        this.i = i;
        this.j = j;
    }
    public Room(Inventory inventory){
        this.inventory = inventory;
    }
    public void addActor(Actor actor){
        Actors.add(actor);
    }
    public void addItems(Inventory inventory){
        this.inventory = inventory;
    }
    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("Room: " + i + " " + j + "\n");
        text.append("Room " + inventory.toString());
        text.append("        - - - - - - - - - - -          \n");
        for(Actor actor: Actors){
            text.append(actor.toString());
        }
        text.append("---------------------------------------\n");
        return text.toString();
    }
}