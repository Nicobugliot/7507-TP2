package test;

import Modelo.Cell;
import Modelo.exceptions.MovementException;
import Modelo.exceptions.OccupiedCellException;
import Modelo.unit.InfantrySoldier;
import org.junit.jupiter.api.Test;
import Modelo.Player;
import Modelo.unit.Unit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CellTest {

    @Test
    void Test00CellIsEmptyReturnTrue() {
        Cell cell = new Cell(0, 0);

        assertEquals(cell.isEmpty(), true);
    }

    @Test
    void Test01CellIsOccupiedWhenHasAnUnit() {
        Cell cell = new Cell(0, 0);
        Unit unit = new TestDummy();

        cell.setUnit(unit);

        assertEquals(cell.isEmpty(), false);
    }

    @Test
    void Test02CellCantSetAnUnitIfItsOccupied() {
        Cell cell = new Cell(0, 0);
        Unit firstUnit = new TestDummy();
        Unit secondUnit = new TestDummy();

        cell.setUnit(firstUnit);

        assertThrows(OccupiedCellException.class, () -> {
           cell.setUnit(secondUnit);
        });
    }

    @Test
    void Test03GetXAndYPositionOfACell() {
        Cell cell = new Cell(0, 1);

        assertEquals(cell.getXPosition(), 0);
        assertEquals(cell.getYPosition(), 1);
    }

    @Test
    void Test04GetAnUnitOfACellAndThenRemoveIt() {
        Cell cell = new Cell(0, 0);

        Unit unit = new TestDummy();
        cell.setUnit(unit);

        assertEquals(cell.getUnit(), unit);

        cell.deleteUnit();

        assertEquals(cell.getUnit(), null);
    }

    private Player player = mock(Player.class);

    @Test
    void Test05InitializeUnitInLocalTeamAreaIsOK() {
        Cell cell = new Cell(0, 0);

        when(player.getTeam()).thenReturn(0);
        cell.setTeam(0);

        Unit unit = new TestDummy();
        cell.initializeUnit(0, unit);

        assertEquals(cell.getUnit(), unit);
    }

    @Test
    void Test06InitializeUnitInRivalTeamAreaThrowsException() {
        Cell cell = new Cell(0, 0);

        when(player.getTeam()).thenReturn(1);
        cell.setTeam(1);

        Unit unit = new TestDummy();

        assertThrows(MovementException.class, () -> {
            cell.initializeUnit(0, unit);
        });
    }

    @Test
    void Test07CellLooseAnUnitWhenItsDies() {
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(1, 0);
        unit.setTeam(0);
        cell.setUnit(unit);
        unit.setCell(cell);

        Cell nextCell = new Cell(0, 0);
        Unit nextUnit = new InfantrySoldier();
        nextUnit.setTeam(1);
        nextUnit.setCell(nextCell);
        for (int i = 0; i < 10; i++) {
            nextUnit.useAbility(unit);
        }

        assertNull(cell.getUnit());
    }
}
