package Modelo.unit;

import Modelo.exceptions.AbilityException;
import Modelo.utils.UtilBoard;

public class Healer extends Unit {
    {
        hp = 75;
        cost = 2;
    }
    private Integer healingAmount = 15;
    private final static Integer MIN_DISTANCE_ATACK = 2;

    public Healer() {
        super(UnitType.HEALER);
    }

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        if( UtilBoard.distanceBetweenCells(this.cell, unit.getCell()) > MIN_DISTANCE_ATACK) {
            throw new AbilityException("No puedo curar a esa distancia");
        }

        if (unit.isAllyOf(this.team)) {
            if (unit.canBeHealed()) {
                unit.applyDamage((-1)*healingAmount);
            }else{
                throw new AbilityException("No puedo curar a la catapulta");
            }
        } else {
            throw new AbilityException("No puedo curar unidades enemigas");
        }

    }


}
