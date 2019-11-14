package unit;

import exceptions.AbilityException;

public class Healer extends Unit {
    {
        hp = 75;
        cost = 2;
    }
    private Integer healingAmount = 15;

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        if (unit.canBeHealed()) {
            unit.applyDamage((-1)*healingAmount);
        }else{
            throw new AbilityException("Can't heal artilley units");
        }
    }


}
