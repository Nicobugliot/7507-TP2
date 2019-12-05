package Modelo;

import Modelo.exceptions.*;
import Modelo.unit.Unit;

import java.util.ArrayList;

public class Player extends Observer{

    private String playerName;
    private Integer points = 20;
    private ArrayList<Unit> playerUnits = new ArrayList<>();
    private Integer team;
    private MasterHand masterHand = new MasterHand();

    public Player(String name){
        this.playerName = name;
    }

    public void setTeam(Integer team){
        this.team = team;
    }

    public Integer getTeam() {
        return this.team;
    }

    public void addUnit(Unit unit) throws InsufficientPointsException{
        Integer price = unit.getCost();
        if(this.points < price){
            throw new InsufficientPointsException("You don't have enough point to buy it");
        }
        this.points -= price;
        unit.setTeam(this.team);
        this.playerUnits.add(unit);
        unit.attachObserver(this);
    }

    public void useUnit(Unit unit, Cell cell){
        if (cell.isEmpty()) {
            throw new EmptyCellException("This cell is empty");
        } else if (!playerUnits.contains(unit)) {
            throw new AbilityException("You can't attack with an enemy unit");
        }
        unit.useAbility(cell.getUnit());
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
        if (playerUnits.contains(unit)) {
            unit.moveTo(nextCell);
        } else {
            throw new MovementException("Esa unidad no te corresponde");
        }
    }

    public void moveBattalion(Unit unit, Cell nextCell) {
        // Verifico que la unidad seleccionada esté dentro de sus unidades.
        if (playerUnits.contains(unit)) {
            unit.moveBattalionTo(nextCell);
        } else {
            throw new MovementException("Esa unidad no te corresponde");
        }
    }

    public Integer getUnitsAmount() {
        return this.playerUnits.size();
    }

    public Integer getPoints(){
        return this.points;
    }

    public String getName() { return this.playerName; }

    @Override
    public void update(Unit unit) {
        looseUnit(unit);
    }
}
