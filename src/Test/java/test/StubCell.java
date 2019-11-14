package test;

import cell.Cell;
import player.Player;
import unit.Unit;

import java.util.HashSet;
import java.util.Set;


public class StubCell{

    private Unit unit;
    private String behaviour = "undefined";
    private boolean alliesNearby = false;
    private boolean enemiesNearby = false;
    private Set<Unit> nearbyUnits = new HashSet<>();

    public Boolean isEmpty() {
        return null;
    }

    public Integer getXPosition() {
        return null;
    }

    public Integer getYPosition() {
        return null;
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


    public void deleteUnit() {

    }

    public void setPlayer(Player player) {

    }

    public boolean containsAllyOf(Integer team) {
        return ( this.unit.isAllyOf(team));
    }

    public Unit getUnit() {
        return unit;
    }

}
