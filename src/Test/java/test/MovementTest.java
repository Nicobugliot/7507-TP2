package test;

import algoChess.AlgoChess;
import cell.AlliedCell;
import cell.Cell;
import exceptions.MovementException;
import exceptions.OccupiedCellException;
import org.junit.jupiter.api.Test;
import player.Player;
import unity.InfantrySoldier;
import unity.Unity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MovementTest{

    @Test
    void Test00TryToMoveAUnityToAnOneDistanceEmptyCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unity infantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(1, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        player.moveUnity(infantrySoldier, nextCell);

        assertEquals(infantrySoldier.getCell(), nextCell);
    }

    @Test
    void Test02TryToMoveAUnityToAnOccupiedCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unity firstInfantrySoldier = new InfantrySoldier();
        Unity secondInfantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(1, 0);

        algoChess.addPlayer(player);
        firstInfantrySoldier.setCell(actualCell);
        secondInfantrySoldier.setCell(nextCell);

        assertThrows(OccupiedCellException.class, () -> {
            player.moveUnity(firstInfantrySoldier, nextCell);
        });
    }

    @Test
    void Test02TryToMoveAUnityToATwoDistanceEmptyCell(){

        AlgoChess algoChess = new AlgoChess();
        Player player = new Player("Jorge");
        Unity infantrySoldier = new InfantrySoldier();
        Cell actualCell = new AlliedCell(1, 1);
        Cell nextCell = new AlliedCell(2, 0);

        algoChess.addPlayer(player);
        infantrySoldier.setCell(actualCell);

        assertThrows(MovementException.class, () -> {
            player.moveUnity(infantrySoldier, nextCell);
        });
    }

}