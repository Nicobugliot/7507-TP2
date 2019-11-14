package unit;

import cell.Cell;
import utils.UtilMovement;

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

    @Override
    public void moveTo(Cell nextCell) {
        Cell actualCell = this.getCell();

        if (UtilMovement.unitCanMove(actualCell, nextCell)){
            // Lleno la nueva celda
            this.setCell(nextCell);

            // Libero la celda anterior
            actualCell.deleteUnit();
            formBattalionIfPossible();//si es posible crea un batallón
        }
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
        if (alignedCandidates.size() > 2){
            Battalion formedBattalion = new Battalion();
            for(Unit alignedCandidate : alignedCandidates){
                formedBattalion.addUnit(alignedCandidate);
            }

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
