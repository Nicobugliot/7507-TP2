package test;

import Modelo.Cell;
import Modelo.unit.Unit;
import Modelo.unit.UnitType;

public class TestDummy extends Unit {

    private Integer hp = 10000;
    private Integer cost = 0;
    private Cell cell;
    private Integer meleeDamage = 0;
    private Integer rangedDamage = 0;
    private String type = "Dummy";
    private Boolean dead = false;
    private Integer damageReceived = 0;

    public TestDummy() {
        super(UnitType.INFANTRY);
    }

    @Override
    public void useAbility(Unit unit) {
        if (unit.isAllyOf(this.team)) {
            unit.applyDamage(meleeDamage);
        }
    }

    @Override
    public void applyDamage(Integer damage) {
        this.hp -= damage;
        this.damageReceived += damage;
    }

    public Integer damageReceived() {
        return this.damageReceived;
    }

}
