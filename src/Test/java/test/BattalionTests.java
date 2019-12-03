package test;

import Modelo.Board;
import Modelo.Cell;
import org.junit.jupiter.api.Test;
import Modelo.unit.Battalion;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattalionTests {

    @Test
    void Test01BattalionMove(){
        Board board = Board.getBoard();

        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Cell cellA = board.getCell(1,1);
        Cell cellB = board.getCell(1,2);
        Cell cellC = board.getCell(1,3);
        Cell cellD = board.getCell(2,1);
        Cell cellE = board.getCell(2,2);
        Cell cellF = board.getCell(2,3);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        battalion.moveTo(cellD);

        assertEquals(cellD.getUnit(),soldierA);
        assertEquals(cellE.getUnit(),soldierB);
        assertEquals(cellF.getUnit(),soldierC);
    }

    @Test
    void Test02BattalionCantMove(){

        Board board = Board.getBoard();
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Unit soldierE = new InfantrySoldier();
        Unit soldierF = new InfantrySoldier();
        Cell cellA = board.getCell(1,1);
        Cell cellB = board.getCell(1,2);
        Cell cellC = board.getCell(1,3);
        Cell cellD = board.getCell(2,1);
        Cell cellE = board.getCell(2,2);
        Cell cellF = board.getCell(2,3);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);
        soldierD.setCell(cellD);
        cellD.setUnit(soldierD);
        soldierE.setCell(cellE);
        cellE.setUnit(soldierE);
        soldierF.setCell(cellF);
        cellF.setUnit(soldierF);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        battalion.moveTo(cellD);

        assertEquals(cellA.getUnit(),soldierA);
        assertEquals(cellB.getUnit(),soldierB);
        assertEquals(cellC.getUnit(),soldierC);
    }

    @Test
    void Test03BattalionOnlyOneSoldierCantMove(){

        Board board = Board.getBoard();
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Cell cellA = board.getCell(1,1);
        Cell cellB = board.getCell(1,2);
        Cell cellC = board.getCell(1,3);
        Cell cellD = board.getCell(2,1);
        Cell cellE = board.getCell(2,2);
        Cell cellF = board.getCell(2,3);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);
        soldierD.setCell(cellD);
        cellD.setUnit(soldierD);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        battalion.moveTo(cellD);

        assertEquals(cellA.getUnit(), soldierA);
        assertEquals(cellE.getUnit(), soldierB);
        assertEquals(cellF.getUnit(), soldierC);
        assertEquals(cellD.getUnit(), soldierD);

    }

    @Test
    void Test04BattalionMove(){

        Board board = Board.getBoard();
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Cell cellA = board.getCell(1,1);
        Cell cellB = board.getCell(2,2);
        Cell cellC = board.getCell(3,3);
        Cell cellD = board.getCell(2,1);
        Cell cellE = board.getCell(3,2);
        Cell cellF = board.getCell(4,3);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);
        soldierD.setCell(cellD);
        cellD.setUnit(soldierD);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        assertEquals(battalion.isEmpty() , false);

        battalion.moveTo(cellD);

        assertEquals(cellA.getUnit(), soldierA);
        assertEquals(cellE.getUnit(), soldierB);
        assertEquals(cellF.getUnit(), soldierC);
        assertEquals(cellD.getUnit(), soldierD);
        assertEquals(battalion.isEmpty() , true);
    }

    @Test
    void Test05ASoldierCanMoveToACellThatWasOccupiedByAnotherBattalionUnit(){

        Board board = Board.getBoard();
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Cell cellA = board.getCell(1,1);
        Cell cellB = board.getCell(1,2);
        Cell cellC = board.getCell(1,3);
        Cell cellD = board.getCell(1,4);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        assertEquals(battalion.isEmpty() , false);

        battalion.moveTo(cellB);

        assertEquals(cellB.getUnit(), soldierA);
        assertEquals(cellC.getUnit(), soldierB);
        assertEquals(cellD.getUnit(), soldierC);
    }
}