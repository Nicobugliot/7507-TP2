package test;

import Modelo.Board;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    @Test
    void Test00BoardInitializeOK() {
        Board board = Board.getBoard();

        assertTrue(board != null);
    }

    @Test
    void Test01BoardAlliesNearby() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 1).setUnit(secondtUnit);

        assertTrue(board.alliesNearby(board.getCell(0, 0), 0));
    }

    @Test
    void Test02BoardDontGetAlliesNearby() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 2).setUnit(secondtUnit);

        assertFalse(board.alliesNearby(board.getCell(0, 0), 0));
    }

    @Test
    void Test03BoardGetEnemiesNearby() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(1);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 1).setUnit(secondtUnit);

        assertTrue(board.enemiesNearby(board.getCell(0, 0), 0));
    }

    @Test
    void Test04BoardGetUnitsNearby() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 1).setUnit(secondtUnit);

        assertNotNull(board.getNearbyUnits(board.getCell(0, 0)));
        assertTrue(board.getNearbyUnits(board.getCell(0, 0)).contains(secondtUnit));
    }

    @Test
    void Test05BoardCantGetUnitsNearby() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 3).setUnit(secondtUnit);

        assertTrue(board.getNearbyUnits(board.getCell(0, 0)).isEmpty());
    }

    @Test
    void Test06BoardGetEnemiesInShortRange() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(1);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 2).setUnit(secondtUnit);

        assertTrue(board.enemiesInShortRange(board.getCell(0, 0), 0));
    }

    @Test
    void Test07BoardCantGetEnemiesInShortRange() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 2).setUnit(secondtUnit);

        assertFalse(board.enemiesInShortRange(board.getCell(0, 0), 0));
    }

    @Test
    void Test07BoardGetAlliesInShortRange() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 2).setUnit(secondtUnit);

        assertTrue(board.alliesInShortRange(board.getCell(0, 0), 0));
    }

    @Test
    void Test08BoardCantGetAlliesInShortRange() {
        Board board = Board.getBoard();
        Unit firstUnit = new InfantrySoldier();
        Unit secondtUnit = new InfantrySoldier();
        firstUnit.setTeam(0);
        secondtUnit.setTeam(0);
        board.getCell(0, 0).setUnit(firstUnit);
        board.getCell(0, 1).setUnit(secondtUnit);

        assertTrue(board.alliesInShortRange(board.getCell(0, 0), 0));
    }
}
