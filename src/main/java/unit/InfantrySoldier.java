package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;
import utils.UtilMovement;

public class InfantrySoldier extends Unit {
    {
        hp = 100;
        cost = 1;
        type = "Infantry";
    }
    private Integer meleeDamage = 10;
    private Boolean dead = false;

    @Override
    public void useAbility(Unit unit) {
        unit.applyDamage(meleeDamage);
    }

}
