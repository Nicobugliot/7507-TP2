package cell;

import cellState.EmptyCell;
import cellState.OccupiedCell;
import cellState.State;
import exceptions.MovementException;
import player.Player;
import unit.Unit;

import java.util.Set;

public class BoardCell implements Cell{

    private Unit unit;
    private State state;
    private Integer xPosition;
    private Integer yPosition;
    private Player player;

    public BoardCell(Integer xPosition, Integer yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.state = new EmptyCell();
    }

    @Override
    public Boolean isEmpty() {
        return state.isEmpty();
    }

    @Override
    public Integer getXPosition() {
        return xPosition;
    }

    @Override
    public Integer getYPosition() {
        return yPosition;
    }

    @Override
    public void changeState(State state){
        this.state = state;
    }

    @Override
    public void setUnit(Unit unit){
        state.setUnit();
        //this.changeState(new OccupiedCell());
        this.unit =  unit;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public void deleteUnit(){
        this.unit = null;
    }

    @Override
    public void setPlayer(Player player) {
        this.player = player;
    }

    @Override
    public void initializeUnit(Unit unit, Player player) {
        if (this.player != player) {
            throw new MovementException("Estas intentando inicializar una unidad en campo enemigo");
        }
        this.setUnit(unit);
    }

    @Override
    public boolean containsAllyOf(Integer team){
        return ( this.unit.isAllyOf(team));
    }
}
