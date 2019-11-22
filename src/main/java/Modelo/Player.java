package Modelo;

import Modelo.exceptions.*;
import Modelo.unit.Unit;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String playerName;
    private Integer points = 20;
    private List<Unit> playerUnits;
    private Integer team;
    private MasterHand masterHand;

    public Player(String name){
        this.playerName = name;
        this.team = team;
        playerUnits = new ArrayList<>();
    }

    public void setTeam(Integer team){
        this.team = team;
    }

    public Integer getTeam() {
        return this.team;
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

    public void useUnit(Unit unit, Cell cell){

        if (!cell.isEmpty()) {
            throw new EmptyCellException("La casilla esta vacia");
        }

        try {
            unit.useAbility(cell.getUnit());
        } catch (AbilityException e) {//TODO Definir un comportamiento para cuando no se pudo utilizar la habilidad
            e.printStackTrace();
        }
    }

    public void looseUnit(Unit unit){
        playerUnits.remove(unit);
        if (playerUnits.size() == 0){
            throw new GameOverException("El usuario "+ playerName +" ha perdido");
        }
    }

    public void initializeUnit(Unit unit, Cell cell) {
        masterHand.initializeUnit(this.team, unit, cell);
    }

    public void moveUnit(Unit unit, Cell nextCell) {
        // Verifico que la unidad seleccionada esté dentro de sus unidades.
        if (this.playerUnits.contains(unit)) {
            unit.moveTo(nextCell);
        }
        throw new MovementException("Esa unidad no te corresponde");
    }

    public Integer getUnitsAmount() {
        return this.playerUnits.size();
    }
}
