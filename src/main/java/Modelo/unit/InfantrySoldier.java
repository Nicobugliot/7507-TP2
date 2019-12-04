package Modelo.unit;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import Modelo.exceptions.BattalionException;
import Modelo.exceptions.MovementException;
import Modelo.utils.UtilBoard;

public class InfantrySoldier extends Unit {
    {
        hp = 100;
        cost = 1;
    }
    private Integer meleeDamage = 10;
    private Battalion battalion = new Battalion();
    private static Integer MIN_DISTANCE_ATACK = 1;
    private Boolean belongsToABattalion;

    public InfantrySoldier() {
        super(UnitType.INFANTRY);
        belongsToABattalion = false;
    }

    @Override
    public void useAbility(Unit unit) {
        if (!unit.isAllyOf(this.team)) {
            if (UtilBoard.distanceBetweenCells(this.cell, unit.getCell()) == MIN_DISTANCE_ATACK){
                unit.applyDamage(meleeDamage);
            }else {
                throw new AbilityException("No puedo atacar a esa distancia");
            }
        } else {
            throw new AbilityException("No podes atacar a unidades aliadas");
        }
    }

    @Override
    public void formBattalion(Unit unitA , Unit unitB) {    //debe recibir las otras dos unidades que forman el batallon

        if (unitA.canFormBattalions() && unitB.canFormBattalions() &&
            (UtilBoard.distanceBetweenCells(this.cell, unitA.getCell()) == 1 || UtilBoard.distanceBetweenCells(this.cell, unitB.getCell()) == 1) &&
            (UtilBoard.distanceBetweenCells(this.cell, unitA.getCell()) == 1 || UtilBoard.distanceBetweenCells(unitA.getCell(), unitB.getCell()) == 1) &&
            (UtilBoard.distanceBetweenCells(this.cell, unitB.getCell()) == 1 || UtilBoard.distanceBetweenCells(unitA.getCell(), unitB.getCell()) == 1)
            ){        //se corrobora que las ingresadas puedan formar batallon
            this.battalion = new Battalion();
            this.battalion.addUnit(this);
            this.battalion.addUnit(unitA);
            this.battalion.addUnit(unitB);
            unitA.joinABattalion();
            unitB.joinABattalion();
            this.joinABattalion();
        } else {
            throw new BattalionException("No podes unirte al batallon");
        }                                                        //habria que lanzar una excepcion si no cumplen
        
        //al mover hay que hacer un for de 3 intentando mover cada unidad que no se haya movido
        //en cuanto se logra mover una unidad, la removemos del batallon y se siguen tratando de mover los miembros restantes
    }

    @Override
    public void moveTo(Cell nextCell) {
        if (belongsToABattalion()) {
            moveBattalionTo(nextCell);
        } else {
            masterHand.moveUnit(this, nextCell);
        }
    }

    @Override
    public boolean canFormBattalions(){
        return true;
    }

    public void moveBattalionTo(Cell nextCellForLeader) {
        if (! battalion.isEmpty()){
            this.battalion.moveTo(nextCellForLeader);
        } else {
            throw new MovementException("Solo el lider puede mover al batallón");
        }
    }

    @Override
    public boolean leadsABattalion() {
        return (! battalion.isEmpty());
    }

    @Override
    public boolean belongsToABattalion() {
        return (belongsToABattalion);
    }

    @Override
    public void joinABattalion(){
        belongsToABattalion = Boolean.TRUE;
    }

    @Override
    public void leaveBattalion(){
        belongsToABattalion = Boolean.FALSE;
    }

    public Battalion getBattalion() {
        return this.battalion;
    }
}
