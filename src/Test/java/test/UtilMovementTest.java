package test;

import cell.Cell;
import org.junit.jupiter.api.Test;
import utils.UtilMovement;

import static org.junit.jupiter.api.Assertions.*;

class UtilMovementTest {

    @Test
    void Test00UnitCanMoveToANeighborCell() {

        Cell originCell = new Cell(1, 1);
        Cell nextCell = new Cell(1, 2);
        UtilMovement utilMovement = new UtilMovement();

        assertTrue(utilMovement.unitCanMove(originCell, nextCell));
    }

    @Test
    void Test01UnitCannotMoveToTheSamePlaceWhereItStands(){

        Cell originCell = new Cell(1, 1);
        Cell nextCell = new Cell(1, 1);
        UtilMovement utilMovement = new UtilMovement();

        assertFalse(utilMovement.unitCanMove(originCell,nextCell));
    }

    @Test
    void Test02UnitCannotMoveToAFarCell(){

        Cell originCell = new Cell(1, 1);
        Cell nextCell = new Cell(1, 3);
        UtilMovement utilMovement = new UtilMovement();

        assertFalse(utilMovement.unitCanMove(originCell,nextCell));
    }

}

