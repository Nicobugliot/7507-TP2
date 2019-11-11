package unit;

import board.Board;
import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.AbilityException;
import utils.UtilMovement;

public abstract class Unit {

    protected Cell cell;
    protected Integer hp;
    protected Integer cost;
    protected Board board;
    protected Integer team;

    public abstract void useAbility(Unit unit) throws AbilityException;

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
        this.hp = 0;
    }

    public Boolean canBeHealed() {
        return true;
    }

    public void setTeam(Integer team){
        this.team = team;
    }

    public boolean isAllyOf(Integer team) {
        return (this.team == team);
    }

    public void setBoard(Board board){
        this.board = board;
    }

    public boolean canFormBattalions(){
        return false;
    }
}
