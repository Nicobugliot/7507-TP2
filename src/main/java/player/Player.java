package player;

import board.Board;
import cell.Cell;
import exceptions.*;
import unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private Integer points = 20;
    private List<Unit> playerUnits;
    private Board board = Board.getBoard();
    private Integer team;

    public Player(String name){
        this.playerName = name;
        this.team = team;
        playerUnits = new ArrayList<>();
    }

    public void setTeam(Integer team){
        this.team = team;
    }

    public void addUnit(Unit unit){
        Integer price = unit.getCost();
        if(this.points < price){
            throw new InsufficientPointsException("No dispone los puntos necesarios para hacer la compra");
        }
        this.points -= price;
        unit.setTeam(this.team);
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

        try {
            unit.useAbility(cell.getUnit());
        } catch (AbilityException e) {//definir un comportamiento para cuando no se pudo utilizar la habilidad
            e.printStackTrace();
        }
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
