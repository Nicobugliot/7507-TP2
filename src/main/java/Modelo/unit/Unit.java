package Modelo.unit;

import Modelo.Board;
import Modelo.Cell;
import Modelo.Observer;
import Modelo.MasterHand;

import java.util.ArrayList;
import java.util.List;

import static Modelo.utils.UtilBoard.distanceBetweenCells;

public abstract class Unit {

    protected Cell cell;
    protected Integer hp;
    protected Integer cost;
    protected static Board board = Board.getBoard();
    protected Integer team;
    protected MasterHand masterHand = new MasterHand();
    protected List<Observer> observers = new ArrayList<Observer>();

    public UnitType getType() {
        return type;
    }

    protected final UnitType type;

    protected Unit(UnitType type) {
        this.type = type;
    }

    public abstract void useAbility(Unit unit);

    public void applyDamage(Integer damage) {
        this.hp -= damage;
        if (this.hp <= 0){
            // Notifico que se murio y elimino todos los observadores
            notifyAllObservers();
            deleteObservers();
        }
    }

    public void setCell(Cell cell) {
        this.cell = cell;
        this.attachObserver(cell);
    }

    public boolean isAlive(){
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

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            System.out.println(observer);
            observer.update(this);
        }
        deleteObservers();
    }

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void deleteObservers() {
        observers.clear();
    }

    public boolean leadsABattalion() { return Boolean.FALSE; }

    public boolean belongsToABattalion() {return Boolean.FALSE; }

    public void joinABattalion(){}

    public void leaveBattalion(){}
}
