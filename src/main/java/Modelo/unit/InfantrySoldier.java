package Modelo.unit;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import Modelo.utils.UtilBoard;

public class InfantrySoldier extends Unit {
    {
        hp = 10;
        cost = 1;
    }
    private Integer meleeDamage = 10;
    private Battalion battalion;
    private static Integer MIN_DISTANCE_ATACK = 1;

    public InfantrySoldier() {
        super(UnitType.INFANTRY);
    }

    @Override
    public void useAbility(Unit unit) {
        if (UtilBoard.distanceBetweenCells(this.cell, unit.getCell()) == MIN_DISTANCE_ATACK){
            unit.applyDamage(meleeDamage);
        }else {
            throw new AbilityException("No puedo atacar a esa distancia");
        }
    }

    private void formBattalionIfPossible(Unit unitA , Unit unitB) {    //debe recibir las otras dos unidades que forman el batallon

        if (unitA.canFormBattalions() && unitB.canFormBattalions()){        //se corrobora que las ingresadas puedan formar batallon
            this.battalion = new Battalion();
            this.battalion.addUnit(this);
            this.battalion.addUnit(unitA);
            this.battalion.addUnit(unitB);
        }                                                         //habria que lanzar una excepcion si no cumplen
        
        //al mover hay que hacer un for de 3 intentando mover cada unidad que no se haya movido
        //en cuanto se logra mover una unidad, la removemos del batallon y se siguen tratando de mover los miembros restantes
    }

    @Override
    public boolean canFormBattalions(){
        return true;
    }

    public void moveBattalion(Cell nextCellA , Cell nextCellB , Cell nextCellC) {
        if (battalion.isEmpty()){
            this.battalion.moveTo(nextCellA , nextCellB , nextCellC);
        }
    }
}
