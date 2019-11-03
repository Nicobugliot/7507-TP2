package cell;

import cellState.EmptyCell;
import cellState.State;
import unity.Unity;

public class EnemyCell implements Cell{

    private Unity unity;
    private State state;
    private Integer xPosition;
    private Integer yPosition;

    public EnemyCell(Integer xPosition, Integer yPosition, Unity unity){
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

    public void changeState(State state){
        this.state = state;
    }

    public void setUnity(Unity unity){
        this.unity =  unity;
    }
}
