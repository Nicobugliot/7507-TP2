package Modelo.unit;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;

public class Rider extends Unit {

    {
        hp = 100;
        cost = 3;
    }

    private Integer meleeDamage = 5;
    private Integer rangedDamage = 15;

    public Rider() {
        super(UnitType.RIDER);
    }

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        Cell myCell = this.cell;
        boolean alliesInShortRange = this.board.alliesInShortRange(myCell, this.team);
        boolean enemiesInShortRange = this.board.enemiesInShortRange(myCell, this.team);
        Integer distance = unit.distanceTo(myCell);
        if (!unit.isAllyOf(this.team)) {
            if (alliesInShortRange || !enemiesInShortRange) {
                unit.applyDamage(rangedDamage);
                return;
            } else if (distance <= 2) {
                unit.applyDamage(meleeDamage);
                return;
            } else throw new AbilityException("The object is out of range");
        } else {
            throw new AbilityException("You can´t attack your own units");
        }
    }

}
