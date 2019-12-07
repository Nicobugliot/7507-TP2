package test;

import Modelo.Board;
import Modelo.Cell;
import Modelo.unit.Catapult;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatapultIntegrationTest {

    @Test
    void Test01CatapultAttackToMoreThanOneEnemy() {
        Board board = Board.getBoard();

        Unit catapult = new Catapult();
        catapult.setTeam(0);

        Unit firstDefender = new InfantrySoldier();
        Unit secondDefender = new InfantrySoldier();
        firstDefender.setTeam(1);
        secondDefender.setTeam(1);

        Cell catapultCell = board.getCell(19, 19);

        Cell defenderFirstCell = board.getCell(0, 0);
        Cell defenderSecondCell = board.getCell(1, 0);

        catapultCell.setUnit(catapult);
        defenderFirstCell.setUnit(firstDefender);
        defenderSecondCell.setUnit(secondDefender);
        catapult.setCell(catapultCell);
        firstDefender.setCell(defenderFirstCell);
        secondDefender.setCell(defenderSecondCell);

        catapult.useAbility(firstDefender);

        assertEquals(firstDefender.getLife(), 80);
        assertEquals(secondDefender.getLife(), 80);
    }

    @Test
    void Test02CatapultAttackToMoreThanTwoEnemy() {
        Board board = Board.getBoard();

        Unit catapult = new Catapult();
        catapult.setTeam(0);

        Unit firstDefender = new InfantrySoldier();
        Unit secondDefender = new InfantrySoldier();
        Unit thirdDefender = new InfantrySoldier();
        firstDefender.setTeam(1);
        secondDefender.setTeam(1);
        thirdDefender.setTeam(1);

        Cell catapultCell = board.getCell(19, 19);

        Cell defenderFirstCell = board.getCell(0, 0);
        Cell defenderSecondCell = board.getCell(1, 0);
        Cell defenderThirdCell = board.getCell(1, 1);


        catapultCell.setUnit(catapult);
        defenderFirstCell.setUnit(firstDefender);
        defenderSecondCell.setUnit(secondDefender);
        defenderThirdCell.setUnit(thirdDefender);
        catapult.setCell(catapultCell);
        firstDefender.setCell(defenderFirstCell);
        secondDefender.setCell(defenderSecondCell);
        thirdDefender.setCell(defenderThirdCell);

        catapult.useAbility(firstDefender);

        assertEquals(firstDefender.getLife(), 80);
        assertEquals(secondDefender.getLife(), 80);
        assertEquals(thirdDefender.getLife(), 80);
    }
}
