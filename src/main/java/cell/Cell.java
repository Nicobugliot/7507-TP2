package cell;

import exceptions.OccupiedCellException;
import player.Player;
import unit.Unit;

public class Cell {

    private Unit unit;
    private Integer xPosition;
    private Integer yPosition;
    private Player player;

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

    public void setUnit(Unit unit) throws OccupiedCellException{
        if (this.isEmpty()) {
            this.unit =  unit;
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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean containsAllyOf(Integer team){
        return ( this.unit.isAllyOf(team));
    }
}
