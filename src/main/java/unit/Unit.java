package unit;

import cell.Cell;

public interface Unit {

    void ability(Unit unit);

    void moveTo(Cell cell);

    void getDamage(Integer damage);

    void setCell(Cell cell);

    Cell getCell();
}
