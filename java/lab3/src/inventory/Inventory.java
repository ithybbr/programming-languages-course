package inventory;
import java.util.ArrayList;
import java.util.Random;
public class Inventory {
    private ArrayList<Item> Items = new ArrayList<>();
    public Inventory(){
    }
    public void generator(){
        Random random = new Random();
        int numberOfArmor = random.nextInt(2);
        int numberOfHealthPotion = random.nextInt(5);
        int numberOfPoison = random.nextInt(5);
        int numberOfWeapon = random.nextInt(2);
        for(int i = 0; i<numberOfArmor; i++){
            int valueOfArmor = (int) (Math.random() * (50 - 30)) + 30;
            Item item = new Armor(valueOfArmor);
            Items.add(item);
        }
        for(int i = 0; i<numberOfHealthPotion; i++){
            int valueOfHealthPotion = (int) (Math.random() * (50 - 30)) + 30;
            Item item = new HealthPotion(valueOfHealthPotion);
            Items.add(item);
        }
        for(int i = 0; i<numberOfPoison; i++){
            int valueOfPoison = (int) (Math.random() * (50 - 30)) + 30;
            Item item = new Poison(valueOfPoison);
            Items.add(item);
        }
        for(int i = 0; i<numberOfWeapon; i++){
            int valueOfWeapon = (int) (Math.random() * (50 - 30)) + 30;
            Item item = new Weapon(valueOfWeapon);
            Items.add(item);
        }
    }
    public String toString(){
        StringBuilder text = new StringBuilder();
        text.append("Inventory: \n");
        for(Item item: Items){
            text.append(item.toString());
        }
            return text.toString() + "\n";
        }
}
