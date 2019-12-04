package test;

import Modelo.Cell;
import Modelo.exceptions.*;
import Modelo.unit.Catapult;
import org.junit.jupiter.api.Test;
import Modelo.Player;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit ;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PlayerTest {

    @Test
    void Test00UserTryToSpendMorePointsThanItHave(){

        Player player = new Player("Jorge");

        for (int i = 0; i < 20; ++i){
            player.addUnit(new InfantrySoldier());
        }

        assertThrows(InsufficientPointsException.class, () -> {
            player.addUnit(new InfantrySoldier());
        });
    }

    @Test
    void Test01UserWithEnoughPointsCanAffordANewUnit(){

        Player player = new Player("Jorge");

        for (int i = 0; i < 20; ++i){
            player.addUnit(new InfantrySoldier());
        }

        assertEquals(player.getUnitsAmount(), 20);
    }

    @Test
    void Test02UserWithoutUnitiesLoseTheGame(){

        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();

        Player player = new Player("Jorge");
        player.addUnit(soldierA);
        player.addUnit(soldierB);

        player.looseUnit(soldierB);

        assertThrows(GameOverException.class, () -> {
            player.looseUnit(soldierA);
        });
    }

    @Test
    void Test03UserLooseAnUnitWithObserver() {
        Player player = new Player("Jorge");
        Unit unit = new InfantrySoldier();
        player.addUnit(unit);

        assertEquals(player.getUnitsAmount(), 1);
        assertThrows(GameOverException.class, () -> {
            unit.applyDamage(100);
        });
    }

    @Test
    void Test04PlayersUnitAttackEnemyUnit() {
        Player player = new Player("Jorge");
        Player enemyPlayer = new Player("Jorge");

        Unit soldier = new InfantrySoldier();
        Unit enemySoldier = new InfantrySoldier();
        player.addUnit(soldier);
        enemyPlayer.addUnit(enemySoldier);
    }

    @Test
    void Test05PlayerSetAndGetTeam() {
        Player player = new Player("Jorge");

        player.setTeam(0);
        assertEquals(player.getTeam(), 0);
    }

    @Test
    void Test06PlayerSetAndGetName() {
        Player player = new Player("Jorge");

        assertEquals(player.getName(), "Jorge");
    }

    @Test
    void Test07PlayerInitializeAUnitInAnEmptyCell() {
        Player player = new Player("Jorge");
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(0, 0);

        player.initializeUnit(unit, cell);

        assertEquals(cell.getUnit(), unit);
    }

    @Test
    void Test08PlayerInitializeAnUnitInAnOccupiedCell() {
        Player player = new Player("Jorge");
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(0, 0);
        cell.setUnit(new Catapult());

        assertThrows(OccupiedCellException.class, () -> {
            player.initializeUnit(unit, cell);
        });
    }

    @Test
    void Test09PlayerInitializeAnUnitInRivalsHouse() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Cell cell = new Cell(0, 0);
        cell.setTeam(1);

        Unit unit = new InfantrySoldier();
        unit.setTeam(0);

        assertThrows(MovementException.class, () -> {
            player.initializeUnit(unit, cell);
        });
    }

    @Test
    void Test10PlayerMoveAnUnitToAnEmptyCell() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Cell cell = new Cell(0, 0);
        cell.setTeam(0);
        Unit unit = new InfantrySoldier();
        unit.setTeam(0);
        unit.setCell(cell);
        player.addUnit(unit);

        Cell nextCell = new Cell(0,1);

        player.moveUnit(unit, nextCell);

        assertEquals(nextCell.getUnit(), unit);
        assertTrue(cell.isEmpty());
    }

    @Test
    void Test11PlayerTryToMoveAnEnemyUnit() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Cell cell = new Cell(0, 0);
        cell.setTeam(0);
        Unit unit = new InfantrySoldier();
        unit.setCell(cell);

        Cell nextCell = new Cell(0,1);

        assertThrows(MovementException.class, () -> {
            player.moveUnit(unit, nextCell);
        });
    }

    @Test
    void Test12PlayerAttackOtherUnitWithHisUnit() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(1, 0);
        unit.setCell(cell);
        player.addUnit(unit);

        Cell nextCell = new Cell(0, 0);
        nextCell.setTeam(1);
        Unit defender = new InfantrySoldier();
        defender.setTeam(1);
        defender.setCell(nextCell);
        nextCell.setUnit(defender);

        player.useUnit(unit, nextCell);

        assertEquals(defender.getLife(), 90);
    }

    @Test
    void Test13PlayerAttackToAnEmptyCell() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(1, 0);
        unit.setCell(cell);
        player.addUnit(unit);

        Cell nextCell = new Cell(0, 0);

        assertThrows(EmptyCellException.class, () -> {
            player.useUnit(unit, nextCell);
        });
    }

    @Test
    void Test14PlayerTryToAttackWithAnEnemyUnit() {
        Player player = new Player("Jorge");
        player.setTeam(0);
        Unit unit = new InfantrySoldier();
        Cell cell = new Cell(1, 0);
        unit.setCell(cell);

        Cell nextCell = new Cell(0, 0);
        nextCell.setUnit(new InfantrySoldier());

        assertThrows(AbilityException.class, () -> {
            player.useUnit(unit, nextCell);
        });
    }
}