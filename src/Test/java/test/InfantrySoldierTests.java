package test;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import Modelo.exceptions.BattalionException;
import Modelo.exceptions.MovementException;
import org.junit.jupiter.api.Test;
import Modelo.unit.*;

import static org.junit.jupiter.api.Assertions.*;
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

    @Test
    void Test03InfantrySoldierCanFormABattalion() {
        Unit leader = new InfantrySoldier();
        Unit soldier1 = new InfantrySoldier();
        Unit soldier2 = new InfantrySoldier();

        Cell nextCell2 = mock(Cell.class);

        leader.setCell(cell);
        leader.setTeam(0);
        soldier1.setCell(nextCell);
        soldier1.setTeam(0);
        soldier2.setCell(nextCell2);
        soldier2.setTeam(0);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(0);
        when(nextCell.getYPosition()).thenReturn(1);

        when(nextCell2.getXPosition()).thenReturn(0);
        when(nextCell2.getYPosition()).thenReturn(2);

        leader.formBattalion(soldier1, soldier2);

        assertTrue(leader.leadsABattalion());
        assertTrue(soldier1.belongsToABattalion());
        assertTrue(soldier2.belongsToABattalion());
    }

    @Test
    void Test04InfantrySoldierCantFormABattalionIfTheyAreFarEnough() {
        Unit leader = new InfantrySoldier();
        Unit soldier1 = new InfantrySoldier();
        Unit soldier2 = new InfantrySoldier();

        Cell nextCell2 = mock(Cell.class);

        leader.setCell(cell);
        leader.setTeam(0);
        soldier1.setCell(nextCell);
        soldier1.setTeam(0);
        soldier2.setCell(nextCell2);
        soldier2.setTeam(0);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(0);
        when(nextCell.getYPosition()).thenReturn(1);

        when(nextCell2.getXPosition()).thenReturn(0);
        when(nextCell2.getYPosition()).thenReturn(3);

        assertThrows(BattalionException.class, () -> {
            leader.formBattalion(soldier1, soldier2);
        });
    }

    @Test
    void Test05InfantrySoldierMoveToAnotherCell() {
        Unit soldier = new InfantrySoldier();
        Cell cell = new Cell(0, 0);
        soldier.setCell(cell);

        Cell nextCell = new Cell(0, 1);
        soldier.moveTo(nextCell);

        assertEquals(nextCell.getUnit(), soldier);
        assertNull(cell.getUnit());
    }

    @Test
    void Test06InfantrySoldierCantMoveToAnotherCellBecauseOfTheDistance() {
        Unit soldier = new InfantrySoldier();
        soldier.setCell(cell);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(0);
        when(nextCell.getYPosition()).thenReturn(2);

        assertThrows(MovementException.class, () -> {
            soldier.moveTo(nextCell);
        });
    }

    @Test
    void Testo07InfantrySoldierCanFormABattalion() {
        Unit unit = new InfantrySoldier();

        assertTrue(unit.canFormBattalions());
    }



}