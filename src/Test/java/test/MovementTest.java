package test;

import algoChess.AlgoChess;
import cell.AlliedCell;
import cell.Cell;
import exceptions.MovementException;
import exceptions.OccupiedCellException;
import org.junit.jupiter.api.Test;
import player.Player;
import unit.InfantrySoldier;
import unit.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Pruebas de todos los movimientos que puede realizar una unidad
 */
class MovementTest{

    private AlgoChess algoChess = new AlgoChess();
    private Player player = new Player("Jorge");
    private Unit infantrySoldier = new InfantrySoldier();
    private Unit secondInfantrySoldier = new InfantrySoldier();

    @Test
    void Test00TryToMoveAUnitToAnOneDistanceEmptyCell(){

        Cell actualCell = algoChess.getCell(1, 1);
        Cell nextCell = algoChess.getCell(1, 2);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        player.moveUnit(infantrySoldier, nextCell);

        assertEquals(infantrySoldier.getCell(), nextCell);
        assertEquals(actualCell.getUnit(), null);
        assertEquals(nextCell.getUnit(), infantrySoldier);
    }

    @Test
    void Test01TryToMoveAUnitToAnOccupiedCell(){

        Cell actualCell = algoChess.getCell(1, 1);
        Cell nextCell = algoChess.getCell(1, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);
        secondInfantrySoldier.setCell(nextCell);

        assertThrows(OccupiedCellException.class, () -> {
            player.moveUnit(infantrySoldier, nextCell);
        });
        assertEquals(actualCell.getUnit(), infantrySoldier);
        assertEquals(nextCell.getUnit(), secondInfantrySoldier);
    }

    @Test
    void Test02TryToMoveAUnitToADiagonalEmptyCell(){

        Cell actualCell = algoChess.getCell(5, 5);
        Cell nextCell = algoChess.getCell(6, 6);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        player.moveUnit(infantrySoldier, nextCell);

        assertEquals(infantrySoldier.getCell(), nextCell);
        assertEquals(actualCell.getUnit(), null);
        assertEquals(nextCell.getUnit(), infantrySoldier);
    }

    @Test
    void Test03TryToMoveAUnitToATwoDistanceEmptyCell(){

        Cell actualCell = algoChess.getCell(1, 1);
        Cell nextCell = algoChess.getCell(3, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        assertThrows(MovementException.class, () -> {
            player.moveUnit(infantrySoldier, nextCell);
        });
        assertEquals(actualCell.getUnit(), infantrySoldier);
    }

    @Test
    void Test04TryToMoveAUnitToTheActualCell(){

        Cell actualCell = algoChess.getCell(1, 1);
        Cell nextCell = algoChess.getCell(1, 1);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        assertThrows(MovementException.class, () -> {
            player.moveUnit(infantrySoldier, nextCell);
        });
        assertEquals(actualCell.getUnit(), infantrySoldier);
    }

}