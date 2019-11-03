package cell;

import cellState.EmptyCell;
import cellState.State;
import unity.Unity;

public class AlliedCell implements Cell{

    private Integer xPosition;
    private Integer yPosition;
    private State state = new EmptyCell();
    private Unity unity;


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

    public void setUnity(Unity unity){
        this.unity =  unity;
    }

}
