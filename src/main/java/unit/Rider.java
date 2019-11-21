package unit;

import cell.Cell;
import exceptions.AbilityException;

public class Rider extends Unit {

    {
        hp = 100;
        cost = 3;
    }

    private Integer meleeDamage = 5;
    private Integer rangedDamage = 15;

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        Cell myCell = this.cell;
        if(this.board.alliesInShortRange(myCell, this.team) || !this.board.enemiesInShortRange(myCell, this.team)){
            unit.applyDamage(rangedDamage);
        }else{
            if(unit.distanceTo(myCell) <= 2) unit.applyDamage(meleeDamage);
            else throw new AbilityException("Objetivo fuera de rango");
        }
    }

}
