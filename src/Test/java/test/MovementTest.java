package test;

import algoChess.AlgoChess;
import cell.AlliedCell;
import cell.Cell;
import exceptions.MovementException;
import exceptions.OccupiedCellException;
import org.junit.jupiter.api.Test;
import player.Player;
import unit.InfantrySoldier;
import unit.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementTest{

    @Test
    void Test00TryToMoveAUnitToAnOneDistanceEmptyCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unit infantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(1, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        player.moveUnit(infantrySoldier, nextCell);

        assertEquals(infantrySoldier.getCell(), nextCell);
        assertEquals(actualCell.getUnit(), null);
        assertEquals(nextCell.getUnit(), infantrySoldier);
    }

    @Test
    void Test02TryToMoveAUnitToAnOccupiedCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unit firstInfantrySoldier = new InfantrySoldier();
        Unit secondInfantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(1, 0);

        algoChess.addPlayer(player);
        firstInfantrySoldier.setCell(actualCell);
        secondInfantrySoldier.setCell(nextCell);

        assertThrows(OccupiedCellException.class, () -> {
            player.moveUnit(firstInfantrySoldier, nextCell);
        });
        assertEquals(actualCell.getUnit(), firstInfantrySoldier);
        assertEquals(nextCell.getUnit(), secondInfantrySoldier);
    }

    @Test
    void Test02TryToMoveAUnitToATwoDistanceEmptyCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unit infantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(2, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        assertThrows(MovementException.class, () -> {
            player.moveUnit(infantrySoldier, nextCell);
        });
        assertEquals(actualCell.getUnit(), infantrySoldier);
    }

}