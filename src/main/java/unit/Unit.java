package unit;

import cell.Cell;

public interface Unit {

    void useAbility(Unit unit);

    void moveTo(Cell cell);

    void appplyDamage(Integer damage);

    void setCell(Cell cell);

    void getCell(Cell cell);

    void isAlive();



    Cell getCell();
}
