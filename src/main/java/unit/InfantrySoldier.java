package unit;

import java.util.HashSet;
import java.util.Set;

public class InfantrySoldier extends Unit {
    {
        hp = 100;
        cost = 1;
    }
    private Integer meleeDamage = 10;
    private Boolean dead = false;

    @Override
    public void useAbility(Unit unit) {
        unit.applyDamage(meleeDamage);
    }

    private void formBattalionIfPossible() {
        Set<Unit> nearbyUnits = board.getNearbyUnits(this.cell);
        Set<Unit> battalionCandidates = new HashSet<>();

        for ( Unit nearbyUnit : nearbyUnits){
            if (nearbyUnit.canFormBattalions()){
                battalionCandidates.add(nearbyUnit);
            }
        }

        Set<Unit> alignedCandidates = alignedUnits(battalionCandidates);
        if (alignedCandidates.size() == 3){
            Battalion formedBattalion = new Battalion();
            for(Unit alignedCandidate : alignedCandidates){
                formedBattalion.addUnit(alignedCandidate);
            }
        }else if (alignedCandidates.size() > 3) {
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
