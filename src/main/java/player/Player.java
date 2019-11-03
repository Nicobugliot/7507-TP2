package player;

import board.Board;
import cell.Cell;
import exceptions.OccupiedCellException;
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
        Board board = Board.getBoard();

        if (!cell.isEmpty()) {
            throw new OccupiedCellException("La casilla esta ocupada");
        }

        unity.moveTo(cell);
    }


}
