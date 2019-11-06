package cell;

import cellState.EmptyCell;
import cellState.State;
import unit.Unit;

import java.util.Set;

public class AlliedCell implements Cell{

    private Integer xPosition;
    private Integer yPosition;
    private State state = new EmptyCell();
    private Unit unit;


    public AlliedCell(Integer xPosition, Integer yPosition){
        this.xPosition = xPosition;
        this.yPosition = yPosition;
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
    public void setXPosition(Integer xPosition){
        this.xPosition = xPosition;
    }

    @Override
    public void setYPosition(Integer yPosition){
        this.yPosition = yPosition;
    }

    public void changeState(State state){
        this.state = state;
    }

    public void setUnit(Unit unit){
        state.setUnit();
        this.unit =  unit;
    }

    @Override
    public Set<Unit> getNearbyUnits() {
        return null;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }

    @Override
    public boolean alliesNearby() {
        return false;
    }

    @Override
    public boolean enemiesNearby() {
        return false;
    }

}
