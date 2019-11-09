package test;

import cell.Cell;
import cellState.State;
import player.Player;
import unit.Unit;

import java.util.HashSet;
import java.util.Set;

public class StubCell implements Cell{

    private Unit unit;
    private String behaviour = "undefined";
    private boolean alliesNearby = false;
    private boolean enemiesNearby = false;
    private Set<Unit> nearbyUnits = new HashSet<>();

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
        this.alliesNearby = false;
        this.enemiesNearby = true;
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
    public void deleteUnit() {

    }

    @Override
    public void setPlayer(Player player) {

    }

    @Override
    public void initializeUnit(Unit unit, Player player) {

    }

    @Override
    public boolean containsAllyOf(Integer team) {
        return ( this.unit.isAllyOf(team));
    }

    @Override
    public Unit getUnit() {
        return unit;
    }


}
