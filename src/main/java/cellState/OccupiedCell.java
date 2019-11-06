package cellState;

import exceptions.OccupiedCellException;

public class OccupiedCell implements State{

    @Override
    public Boolean isEmpty() {
        return false;
    }

    @Override
    public void setUnit(){
        throw new OccupiedCellException("La celda esta ocupada");
    }
}
