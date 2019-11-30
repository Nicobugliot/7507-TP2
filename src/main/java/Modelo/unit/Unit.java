package Modelo.unit;

import Modelo.Board;
import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import Modelo.MasterHand;

import static Modelo.utils.UtilBoard.distanceBetweenCells;

public abstract class Unit {

    protected Cell cell;
    protected Integer hp;
    protected Integer cost;
    protected Board board;
    protected Integer team;
    protected MasterHand masterHand = new MasterHand();

    public UnitType getType() {
        return type;
    }

    protected final UnitType type;

    protected Unit(UnitType type) {
        this.type = type;
    }

    public abstract void useAbility(Unit unit) throws AbilityException;

    public void applyDamage(Integer damage) {
        this.hp -= damage;
        if (this.hp <= 0){
            this.die();
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
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

    public void moveTo(Cell nextCell) {
        masterHand.moveUnit(this, nextCell);
    }

    public int distanceTo(Cell targetCell){
        return distanceBetweenCells(this.cell, targetCell);
    }

    public Integer getLife() {
        return this.hp;
    }
}
