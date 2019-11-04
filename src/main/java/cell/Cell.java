package cell;

import cellState.State;
import unit.Unit;

public interface Cell {

    Boolean isEmpty();

    Integer getXPosition();

    Integer getYPosition();

    void setXPosition(Integer xPosition);

    void setYPosition(Integer yPosition);

    void changeState(State state);

    void setUnit(Unit unit);

    Unit getUnit();

}
