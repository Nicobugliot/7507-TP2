package Modelo;

import Modelo.exceptions.MovementException;
import Modelo.exceptions.OccupiedCellException;
import Modelo.unit.Unit;

public class Cell extends Observer{

    private Unit unit;
    private Integer xPosition;
    private Integer yPosition;
    private Integer team;

    public Cell(Integer xPosition, Integer yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public Boolean isEmpty() {
        return (this.unit == null);
    }

    public Integer getXPosition() {
        return xPosition;
    }

    public Integer getYPosition() {
        return yPosition;
    }

    public void setUnit(Unit unit) {
        if (this.isEmpty()) {
            this.unit = unit;
        }else {
            throw new OccupiedCellException("La celda está ocupada");
        }
    }

    public Unit getUnit() {
        return unit;
    }

    public void deleteUnit(){
        this.unit = null;
    }

    public void setTeam(Integer team) {
        this.team = team;
    }

    public void initializeUnit(Integer team, Unit unit) {
        if (this.team != team) {
            throw new MovementException("You can't initialize a unity in an enemy's field");
        }
        this.setUnit(unit);
        unit.setCell(this);
    }

    public boolean containsAllyOf(Integer team){
        return ( this.unit.isAllyOf(team));
    }

    @Override
    public void update(Unit unit) {
        deleteUnit();
    }
}
