package cell;

import cellState.State;
import unity.Unity;

public interface Cell {

    Boolean isEmpty();

    Integer getXPosition();

    Integer getYPosition();

    void setXPosition(Integer xPosition);

    void setYPosition(Integer yPosition);

    void changeState(State state);

    void setUnity(Unity unity);

    Unity getUnity();

}