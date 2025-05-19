package inventory;

public class Poison extends Consumable{
    private int destroyPower;
    public Poison(int destroyPower){
        this.destroyPower = destroyPower;
    }
    public String toString(){
        return "Poison: with Destroy power: " + destroyPower + "\n";
    }
}
