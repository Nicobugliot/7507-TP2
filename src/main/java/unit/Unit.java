package unit;

import cell.Cell;

public interface Unit {

    void useAbility(Unit unit);

    void moveTo(Cell cell);

    void applyDamage(Integer damage);

    void setCell(Cell cell);

    Cell getCell(Cell cell);

    boolean isAlive();

    Integer getCost();

    Cell getCell();

    void die();

    String type();
}
