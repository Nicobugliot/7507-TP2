package test;

import exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InfantrySoldierTests {


    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }

        assertEquals(((TestDummy) defender).damageReceived(), 10);
    }

}