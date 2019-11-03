package unity;

import cell.Cell;

public interface Unity {

    void ability(Unity unity);

    void moveTo(Cell cell);

    void getDamage(Integer damage);

    void setCell(Cell cell);

    Cell getCell();
}
