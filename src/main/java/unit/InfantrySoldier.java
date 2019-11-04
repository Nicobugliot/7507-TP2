package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class InfantrySoldier implements Unit{

    private Integer hp = 100;
    private Integer cost = 1;
    private Cell cell;
    private Integer meleeDamage = 10;
    private Integer rangedDamage = 0;
    private String type = "Infantry";
    private Boolean dead = false;

    @Override
    public void useAbility(Unit unit) {
        unit.applyDamage(meleeDamage);
    }

    @Override
    public void moveTo(Cell nextCell) {
        Cell actualCell = this.getCell();

        if (this.unitCanMove(actualCell, nextCell)){
            // Libero la celda
            actualCell.changeState(new EmptyCell());
            actualCell.setUnit(null);

            // Lleno la nueva celda
            nextCell.changeState(new OccupiedCell());
            nextCell.setUnit(this);
            this.setCell(nextCell);
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
    public Cell getCell(Cell cell) {
        return this.cell;
    }

    @Override
    public Cell getCell() {
        return this.cell;
    }

    private Boolean unitCanMove(Cell actualCell, Cell nextCell){

        if(!(getDistance(actualCell, nextCell) == 1)){
            throw new MovementException("No puedo moverme hasta ahi");
        }
        return true;
    }

    private Integer getDistance(Cell actualCell, Cell nextCell){
        Integer xPosition = Math.abs(actualCell.getXPosition() - nextCell.getXPosition());
        Integer yPosition = Math.abs(actualCell.getYPosition() - nextCell.getYPosition());

        return xPosition + yPosition;
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
