package inventory;

public class Armor extends Equipment{
    private int armor;
    public Armor(int armor){
        this.armor = armor;
    }
    public String toString(){
        return "Armor: with Defense power: " + armor + "\n";
    }
}
