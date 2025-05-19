package game;
import actors.Actor;
import actors.Enemy;
import actors.Player;
import inventory.Inventory;

public class GameMap {
    int i;
    int j;
    int enemies;
    private Room[][] grid;
    public GameMap(int i, int j, int enemies){
        this.i = i;
        this.j = j;
        this.enemies = enemies;
        grid = new Room[i][j];
        /* the first version
        initializeMap();
        addEnemies();
        addItems();
        addPlayer(); //used to also create an instance of player 
        */
    }
    public void createGame(Player player){
        initializeMap();
        addEnemies();
        addItems();
        addPlayer(player);
    }
    public void initializeMap() {
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++) {
                grid[i][j] = new Room(i, j);
            }
        }
    }
    public void addEnemies() {
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++) {
                for(int k = 0; k < enemies; k++){
                    Inventory inventory = new Inventory();
                    inventory.generator();
                    Actor enemy = new Enemy(inventory);
                    grid[i][j].addActor(enemy);
                }
            }
        }
    }
    public void addItems() {
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++) {
                    Inventory inventory = new Inventory();
                    inventory.generator();
                    grid[i][j].addItems(inventory);
            }
        }
    }
    public void addPlayer(Player player){
        int min = 0;
        int max = i*j;
        int locationOfPlayer = (int) (Math.random() * (max - min)) + min;
        int k = 0;
         for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++){
                if(locationOfPlayer == k){
                    grid[i][j].addActor(player);
                }
                k++;
            }
        }
    }
    public String printMap(){
        StringBuilder text = new StringBuilder();
        for(int i = 0; i < this.i; i++){
            for(int j = 0; j < this.j; j++){
                text.append(grid[i][j].toString());
            }
        }
        return text.toString();
    }
}
