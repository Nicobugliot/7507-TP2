package unit;

import exceptions.AbilityException;
import utils.UtilBoard;

import java.util.HashSet;
import java.util.Set;

public class InfantrySoldier extends Unit {
    {
        hp = 100;
        cost = 1;
    }
    private Integer meleeDamage = 10;
    private Boolean dead = false;
    private static Integer MIN_DISTANCE_ATACK = 1;

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        if (UtilBoard.distanceBetweenCells(this.cell, unit.getCell()) == MIN_DISTANCE_ATACK){
            unit.applyDamage(meleeDamage);
        }else {
            throw new AbilityException("No puedo atacar a esa distancia");
        }
    }

    private void formBattalionIfPossible() {
        Set<Unit> nearbyUnits = board.getNearbyUnits(this.cell);
        Set<Unit> battalionCandidates = new HashSet<>();

        for (Unit nearbyUnit : nearbyUnits){
            if (nearbyUnit.canFormBattalions()){
                battalionCandidates.add(nearbyUnit);
            }
        }

        Set<Unit> alignedCandidates = alignedUnits(battalionCandidates);
        if (alignedCandidates.size() == 2){
            Battalion formedBattalion = new Battalion();
            for(Unit alignedCandidate : alignedCandidates){
                formedBattalion.addUnit(alignedCandidate);
            }
        }else if (alignedCandidates.size() >= 3) {
            //TODO Hacer que pueda elegir qué soldados puedan conformar su batallón.
        }
    }

    private Set<Unit> alignedUnits(Set<Unit> battalionCandidates) {
        Set<Unit> alignedUnits = new HashSet<>();
        return alignedUnits;
    }

    @Override
    public boolean canFormBattalions(){
        return true;
    }
}
