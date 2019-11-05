package test;

import algoChess.AlgoChess;
import cell.AlliedCell;
import cell.AlliedCell;
import cell.Cell;
import exceptions.MovementException;
import exceptions.OccupiedCellException;
import org.junit.jupiter.api.Test;
import player.Player;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitSimpleCombatTest{

    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new InfantrySoldier();
        Integer HPBeforeAttack = damaged.getRemainingHP();
        Integer expectedHP = HPBeforeAttack - 10;

        attacker.useAbility(defender);
        Integer HPAfterAttack = defender.getRemainingHP();

        assertEquals(HPAfterAttack, expectedHP);
    }

    @Test
    void Test01IRiderMeleeAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new Rider();
        Unit defender = new Rider();
        Integer HPBeforeAttack = damaged.getRemainingHP();
        Integer expectedHP = HPBeforeAttack - 10;

        attacker.useAbility(defender);
        Integer HPAfterAttack = defender.getRemainingHP();

        assertEquals(HPAfterAttack, expectedHP);
    }



}