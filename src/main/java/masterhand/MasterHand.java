package masterhand;

import cell.Cell;
import unit.Unit;

public class MasterHand {

    public void moveUnit(Unit unit, Cell nextCell) {
        nextCell.setUnit(unit);
        unit.getCell().deleteUnit();
    }

    public void initializeUnit(Unit unit, Cell cell) {
        cell.setUnit(unit);
    }

}
