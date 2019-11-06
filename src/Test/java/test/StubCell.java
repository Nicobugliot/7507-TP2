package cell;

import cell.Cell;
import cellState.State;
import unit.Unit;

import java.util.Set;

public class StubCell implements Cell{

    private Unit unit;
    private String behaviour = "undefined";
    private boolean alliesNearby = false;
    private boolean enemiesNearby = false;
    private Set<Unit> nearbyUnits;

    @Override
    public Boolean isEmpty() {
        return null;
    }

    @Override
    public Integer getXPosition() {
        return null;
    }

    @Override
    public Integer getYPosition() {
        return null;
    }

    @Override
    public void setXPosition(Integer xPosition) {

    }

    @Override
    public void setYPosition(Integer yPosition) {

    }

    @Override
    public void changeState(State state) {

    }

    public void setUnit(Unit unit){
        this.unit =  unit;
    }

    public void pretendAlone(){
        this.behaviour = "alone";
        this.alliesNearby = false;
        this.enemiesNearby = false;
    }

    public void pretendAlliesNearby(){
        this.behaviour = "alliesNearby";
        this.alliesNearby = true;
        this.enemiesNearby = false;
    }

    public void pretendEnemiesNearby(){
        this.behaviour = "alliesNearby";
        this.alliesNearby = true;
        this.enemiesNearby = false;
    }

    public void pretendEnemiesAndAlliesNearby(){
        this.behaviour = "alliesNearby";
        this.alliesNearby = true;
        this.enemiesNearby = false;
    }

    public void addNearbyUnit(Unit unit){
        this.nearbyUnits.add(unit);
    }

    @Override
    public boolean alliesNearby(){
        return this.alliesNearby;
    }

    @Override
    public boolean enemiesNearby(){
        return this.enemiesNearby;
    }

    @Override
    public void deleteUnit() {

    }

    @Override
    public Set<Unit> getNearbyUnits(){
        return this.nearbyUnits;
    }

    @Override
    public Unit getUnit() {
        return unit;
    }


}
