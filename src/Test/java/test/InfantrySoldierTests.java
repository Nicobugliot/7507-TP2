package test;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import Modelo.unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class InfantrySoldierTests {

    private Cell cell = mock(Cell.class);
    private Cell nextCell = mock(Cell.class);

    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.setCell(cell);
        attacker.setTeam(0);
        defender.setCell(nextCell);
        defender.setTeam(1);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(1);
        when(nextCell.getYPosition()).thenReturn(1);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }

        assertEquals(((TestDummy) defender).damageReceived(), 10);
    }

    @Test
    void Test01InfantrySoldierCantAttackBecauseOfTheDistance(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.setCell(cell);
        attacker.setTeam(0);
        defender.setCell(nextCell);
        attacker.setTeam(1);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(2);
        when(nextCell.getYPosition()).thenReturn(1);

        assertThrows(AbilityException.class, () -> {
           attacker.useAbility(defender);
        });
    }

    @Test
    void Test02InfantrySoldierCantAttackAnAllyUnit(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.setCell(cell);
        attacker.setTeam(0);
        defender.setCell(nextCell);
        attacker.setTeam(0);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(2);
        when(nextCell.getYPosition()).thenReturn(1);

        assertThrows(AbilityException.class, () -> {
            attacker.useAbility(defender);
        });
    }

}