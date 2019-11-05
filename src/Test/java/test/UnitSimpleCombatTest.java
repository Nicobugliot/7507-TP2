package test;

import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitSimpleCombatTest{

    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();
        Integer HPBeforeAttack = damaged.getRemainingHP();
        Integer expectedHP = HPBeforeAttack - 10;

        attacker.useAbility(defender);
        Integer HPAfterAttack = defender.getRemainingHP();

        assertEquals(HPAfterAttack, expectedHP);
    }

    @Test
    void Test01IRiderMeleeAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Integer HPBeforeAttack = damaged.getRemainingHP();
        Integer expectedHP = HPBeforeAttack - 10;

        attacker.useAbility(defender);
        Integer HPAfterAttack = defender.getRemainingHP();

        assertEquals(HPAfterAttack, expectedHP);
    }



}