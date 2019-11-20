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
    void Test01HealerHealsForExpectedAmount(){
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

        battalion.moveTo(cellD , cellE , cellF);        //aca esta el error

        assertEquals(1,1);
    }

}