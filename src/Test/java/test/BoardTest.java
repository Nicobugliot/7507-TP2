package test;

import algoChess.AlgoChess;
import cell.Cell;
import exceptions.MovementException;
import org.junit.jupiter.api.Test;
import player.Player;
import unit.InfantrySoldier;
import unit.Unit;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private static Player firstPlayer = new Player("firstPlayer");
    private static Player secondPlayer = new Player("secondPlayer");

    @Test
    void Test00InitializeBoardIsOK() {
        AlgoChess algoChess = new AlgoChess();

        algoChess.addPlayer(firstPlayer);
        algoChess.addPlayer(secondPlayer);

        algoChess.setBoard(firstPlayer, secondPlayer);

        assertTrue(algoChess.getCell(1,1) != null);
    }

    @Test
    void Test01TryToInitializeAnUnitInAlliedCell() {
        AlgoChess algoChess = new AlgoChess();
        Unit infantrySoldier = new InfantrySoldier();

        algoChess.addPlayer(firstPlayer);
        algoChess.addPlayer(secondPlayer);

        algoChess.setBoard(firstPlayer, secondPlayer);

        Cell alliedCell = algoChess.getCell(1, 1);

        firstPlayer.initializeUnit(infantrySoldier, alliedCell);

        assertEquals(alliedCell.getUnit(), infantrySoldier);
    }

    @Test
    void Test02TryToInitializeAnUnitInEnemyCell() {
        AlgoChess algoChess = new AlgoChess();
        Unit infantrySoldier = new InfantrySoldier();

        algoChess.addPlayer(firstPlayer);
        algoChess.addPlayer(secondPlayer);

        algoChess.setBoard(firstPlayer, secondPlayer);

        Cell alliedCell = algoChess.getCell(0, 0);

        assertThrows(MovementException.class, () -> {
            secondPlayer.initializeUnit(infantrySoldier, alliedCell);
        });

    }

    @Test
    void Test03TryToInitializeAnUnitInEnemyCell() {
        AlgoChess algoChess = new AlgoChess();
        Unit infantrySoldier = new InfantrySoldier();

        algoChess.addPlayer(firstPlayer);
        algoChess.addPlayer(secondPlayer);

        algoChess.setBoard(firstPlayer, secondPlayer);

        Cell alliedCell = algoChess.getCell(0, 0);

        assertThrows(MovementException.class, () -> {
            secondPlayer.initializeUnit(infantrySoldier, alliedCell);
        });

    }



}
