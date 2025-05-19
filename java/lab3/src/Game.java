import actors.Player;
import game.GameMap;

public class Game {
    private GameMap map;
    public Game(int i, int j, int enemies, Player player){
        map = new GameMap(i, j, enemies);
        createGame(player);
    }
    public void createGame(Player player){
        map.createGame(player);
    }
    public void printMap(){
        System.out.println(map.printMap());
    }  
}
