package Modelo;

import Modelo.exceptions.MovementException;
import Modelo.exceptions.OccupiedCellException;
import Modelo.unit.Unit;
import Modelo.utils.UtilMovement;

public class MasterHand {

    public void moveUnit(Unit unit, Cell nextCell) {
        if (UtilMovement.unitCanMove(unit.getCell(), nextCell)){
            nextCell.setUnit(unit);
            unit.getCell().deleteUnit();
            unit.setCell(nextCell);
        } else {
            throw new MovementException("No puedo moverme hasta ahi");
        }
    }

    public void initializeUnit(Integer team, Unit unit, Cell cell) {
        cell.initializeUnit(team, unit);
    }

}
