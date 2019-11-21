package test;

import cell.Cell;
import exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import unit.Battalion;
import unit.InfantrySoldier;
import unit.Unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BattalionTests {

    @Test
    void Test01BattalionMove(){
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Cell cellA = new Cell(1,1);
        Cell cellB = new Cell(1,2);
        Cell cellC = new Cell(1,3);
        Cell cellD = new Cell(2,1);
        Cell cellE = new Cell(2,2);
        Cell cellF = new Cell(2,3);

        soldierA.setCell(cellA);
        cellA.setUnit(soldierA);
        soldierB.setCell(cellB);
        cellB.setUnit(soldierB);
        soldierC.setCell(cellC);
        cellC.setUnit(soldierC);

        battalion.addUnit(soldierA);
        battalion.addUnit(soldierB);
        battalion.addUnit(soldierC);

        battalion.moveTo(cellD , cellE , cellF);

        assertEquals(cellD.getUnit(),soldierA);
        assertEquals(cellE.getUnit(),soldierB);
        assertEquals(cellF.getUnit(),soldierC);
    }

    @Test
    void Test02BattalionCantMove(){
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Unit soldierE = new InfantrySoldier();
        Unit soldierF = new InfantrySoldier();
        Cell cellA = new Cell(1,1);
        Cell cellB = new Cell(1,2);
        Cell cellC = new Cell(1,3);
        Cell cellD = new Cell(2,1);
        Cell cellE = new Cell(2,2);
        Cell cellF = new Cell(2,3);

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

        battalion.moveTo(cellD , cellE , cellF);

        assertEquals(cellA.getUnit(),soldierA);
        assertEquals(cellB.getUnit(),soldierB);
        assertEquals(cellC.getUnit(),soldierC);
    }

    @Test
    void Test03BattalionOnlyOneSoldierCantMove(){
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Cell cellA = new Cell(1,1);
        Cell cellB = new Cell(1,2);
        Cell cellC = new Cell(1,3);
        Cell cellD = new Cell(2,1);
        Cell cellE = new Cell(2,2);
        Cell cellF = new Cell(2,3);

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

        battalion.moveTo(cellD , cellE , cellF);

        assertEquals(cellA.getUnit(), soldierA);
        assertEquals(cellE.getUnit(), soldierB);
        assertEquals(cellF.getUnit(), soldierC);
        assertEquals(cellD.getUnit(), soldierD);

    }

    @Test
    void Test04BattalionMove(){
        Battalion battalion = new Battalion();
        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();
        Unit soldierC = new InfantrySoldier();
        Unit soldierD = new InfantrySoldier();
        Cell cellA = new Cell(1,1);
        Cell cellB = new Cell(2,2);
        Cell cellC = new Cell(3,3);
        Cell cellD = new Cell(2,1);
        Cell cellE = new Cell(3,2);
        Cell cellF = new Cell(4,3);

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

        assertEquals(battalion.isNotEmpty() , Boolean.TRUE);

        battalion.moveTo(cellD , cellE , cellF);

        assertEquals(cellA.getUnit(), soldierA);
        assertEquals(cellE.getUnit(), soldierB);
        assertEquals(cellF.getUnit(), soldierC);
        assertEquals(cellD.getUnit(), soldierD);
        assertEquals(battalion.isNotEmpty() , Boolean.FALSE);
    }
}