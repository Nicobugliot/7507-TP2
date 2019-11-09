package unit;

import cell.Cell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class Healer extends Unit {
    {
        hp = 75;
        cost = 2;
    }
    private Integer healingAmount = 15;

    @Override
    public void useAbility(Unit unit) {
        if (unit.canBeHealed()) {//si no es una catapulta
            unit.applyDamage((-1)*healingAmount);
        }else{
            //throw new AbilityException("Can't heal artilley units");
        }
    }


}
