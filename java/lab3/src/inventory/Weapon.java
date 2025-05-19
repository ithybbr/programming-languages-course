package inventory;

public class Weapon extends Equipment{
    private int attackPower;
    public Weapon(int attackPower){
        this.attackPower = attackPower;
    }
    public String toString(){
        return "Weapon: with Attack power: " + attackPower + "\n";
    }
}
