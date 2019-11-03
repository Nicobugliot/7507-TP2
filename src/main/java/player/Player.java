package player;

import cell.Cell;
import unity.Unity;

import java.util.List;

public class Player {

    private String playerName;
    private Integer points = 20;
    private List<Unity> playerUnity;

    public Player(String name){
        this.playerName = name;
    }

    public void addUnity(Unity unity){
        playerUnity.add(unity);
    }

    public void moveUnity(Unity unity, Cell cell){
        unity.moveTo(cell);
    }


}
