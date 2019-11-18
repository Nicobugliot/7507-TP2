package test;

import board.Board;
import cell.Cell;
import exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import unit.*;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CatapultTests {

    @Test
    void Test01CatapultBlastDamagesTargetForExpectedAmount(){

        //Hago un mock del tablero
        Board boardMock = mock(Board.class);
        Cell cell = mock(Cell.class);

        Unit catapult = new Catapult();
        Unit target = new TestDummy();
        target.setCell(cell);//asigno a la unidad objetivo la celda objetivo
        catapult.setBoard(boardMock);//asigno el tablero mockeado a la catapulta

        //Genero un set vacio para que simule el mock
        Set<Unit> affectedUnits = new HashSet<>();

        //Le indico al mock del tablero que cuando le pregunten que unidadades rodean a la celda afectada devuelva vacio
        when(boardMock.getNearbyUnits(cell)).thenReturn(affectedUnits);

        try {
            catapult.useAbility(target);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por la catapulta
        assertEquals(((TestDummy) target).damageReceived(), 20);
    }

}