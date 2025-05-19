import actors.Player;
import inventory.Inventory;

public class Main {
    public static void main(String[] args) {
    Inventory inventory = new Inventory();
    inventory.generator();
    Player player = new Player(inventory);
    Game game = new Game(3, 5, 2, player); // the original implementation took only n and number of enemies
    game.printMap();
    }
}
