package cell;

import cellState.State;
import unit.Unit;

import java.util.Set;

public interface Cell {

    Boolean isEmpty();

    Integer getXPosition();

    Integer getYPosition();

    void setXPosition(Integer xPosition);

    void setYPosition(Integer yPosition);

    void changeState(State state);

    void setUnit(Unit unit);

    Set<Unit> getNearbyUnits();

    Unit getUnit();

    //Returns true if there are allies surrounding the cell
    boolean alliesNearby();

    //Returns true if there are enemies surrounding the cell
    boolean enemiesNearby();
}
