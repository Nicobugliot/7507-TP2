package test;

import cell.Cell;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CatapultTests {


    @Test
    void Test01CatapultBlastDamagesTargetForExpectedAmount(){
        Unit catapult = new Catapult();
        Unit subject = new TestDummy();
        Cell targetCell = new StubCell();

        //configuro el stub para que diga que la única unidad cercana a la zona de impacto es la unidad objetivo
        ((StubCell) targetCell).addNearbyUnit(subject);
        subject.setCell(targetCell);

        catapult.useAbility(subject);
        //verifico que el daño aplicado corresponda con el realizado por la catapulta
        assertEquals(((TestDummy) subject).damageReceived(), 20);
    }

}