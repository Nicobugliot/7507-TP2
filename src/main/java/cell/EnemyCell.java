package cell;

import cellState.EmptyCell;
import cellState.State;
import unit.Unit;

import java.util.Set;

public class EnemyCell implements Cell{

    private Unit unit;
    private State state;
    private Integer xPosition;
    private Integer yPosition;

    public EnemyCell(Integer xPosition, Integer yPosition, Unit unit){
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
    public void setXPosition(Integer xPosition) {
        this.xPosition = xPosition;
    }

    @Override
    public void setYPosition(Integer yPosition) {
        this.yPosition = yPosition;
    }

    @Override
    public void changeState(State state){
        this.state = state;
    }

    @Override
    public void setUnit(Unit unit){
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
