package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import utils.UtilMovement;

public abstract class Unit {

    protected Cell cell;
    protected Integer hp;
    protected Integer cost;
    protected String type;

    public abstract void useAbility(Unit unit);

    public void moveTo(Cell nextCell) {
        Cell actualCell = this.getCell();

        if (UtilMovement.unitCanMove(actualCell, nextCell)){
            // Lleno la nueva celda
            this.setCell(nextCell);

            // Libero la celda anterior
            actualCell.changeState(new EmptyCell());
            actualCell.deleteUnit();
        }
    }

    public void applyDamage(Integer damage) {
        this.hp -= damage;
        if (this.hp <= 0){
            this.die();
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        cell.setUnit(this);
        cell.changeState(new OccupiedCell());
    }

    boolean isAlive(){
        return (hp > 0);
    }

    public Integer getCost(){
        return  this.cost;
    }

    public Cell getCell() {
        return this.cell;
    }

    public void die() {

    }

    public String type() {
        return this.type;
    }
}
