package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;
import utils.UtilMovement;

public class InfantrySoldier implements Unit{

    private Integer hp = 100;
    private Integer cost = 1;
    private Cell cell;
    private Integer meleeDamage = 10;
    private String type = "Infantry";
    private Boolean dead = false;

    @Override
    public void useAbility(Unit unit) {
        unit.applyDamage(meleeDamage);
    }

    @Override
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

    @Override
    public void applyDamage(Integer damage) {
        this.hp -= damage;
        if (this.hp <= 0){
            this.die();
        }
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
        cell.setUnit(this);
        cell.changeState(new OccupiedCell());
    }

    @Override
    public boolean isAlive() {
        return !this.dead;
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }

    public String type() {
        return this.type;
    }

    @Override
    public Integer getCost() {
        return cost;
    }

    @Override
    public void die() {
        this.dead = true;
    }
}
