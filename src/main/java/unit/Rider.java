package unit;

import cell.Cell;

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
        if(this.board.alliesInShortRange(myCell, this.team) || !this.board.enemiesInShortRange(myCell, this.team)){
            unit.applyDamage(rangedDamage);
        }else{
            unit.applyDamage(meleeDamage);
        }
    }

}
