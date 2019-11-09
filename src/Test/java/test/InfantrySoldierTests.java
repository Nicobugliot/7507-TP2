package test;

import cell.Cell;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfantrySoldierTests {


    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.useAbility(defender);

        assertEquals(((TestDummy) defender).damageReceived(), 10);
    }

}