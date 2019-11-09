package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class Rider extends Unit {

    {
        hp = 100;
        cost = 3;
    }

    private Integer meleeDamage = 5;
    private Integer rangedDamage = 15;

    @Override
    public void useAbility(Unit unit) {
        Cell myCell = this.cell;
        if(this.board.alliesNearby(myCell, this.team) || !this.board.enemiesNearby(myCell, this.team)){
            unit.applyDamage(rangedDamage);
        }else{
            unit.applyDamage(meleeDamage);
        }
    }


}
