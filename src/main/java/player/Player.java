package player;

import board.Board;
import cell.Cell;
import exceptions.EmptyCellException;
import exceptions.GameOverException;
import exceptions.InsufficientPointsException;
import exceptions.OccupiedCellException;
import unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private Integer points = 20;
    private List<Unit> playerUnits;
    private Board board = Board.getBoard();

    public Player(String name){
        this.playerName = name;
        playerUnits = new ArrayList<>();
    }

    public void addUnit(Unit unit){
        Integer price = unit.getCost();
        if(this.points < price){
            throw new InsufficientPointsException("No dispone los puntos necesarios para hacer la compra");
        }
        this.points -= price;
        this.playerUnits.add(unit);
    }

    public void moveUnit(Unit unit, Cell cell){
        unit.moveTo(cell);
    }

    public void initializeUnit(Unit unit, Cell cell) {
        cell.initializeUnit(unit, this);
        unit.setCell(cell);
    }

    public void useUnit(Unit unit, Cell cell){

        if (!cell.isEmpty()) {
            throw new EmptyCellException("La casilla esta vacia");
        }

        unit.useAbility(cell.getUnit());
    }

    public void looseUnit(Unit unit){
        playerUnits.remove(unit);
        if (playerUnits.size() == 0){
            throw new GameOverException("El usuario "+ playerName +" ha perdido");
        }
    }

    public Integer getUnitsAmount() {
        return this.playerUnits.size();
    }
}
