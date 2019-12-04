package test;

import Modelo.Board;
import Modelo.Cell;
import Modelo.Player;
import Modelo.exceptions.AbilityException;
import Modelo.exceptions.MovementException;
import org.junit.jupiter.api.Test;
import Modelo.unit.*;
import Modelo.utils.UtilBoard;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CatapultTests {

    @Test
    void Test01CatapultBlastDamagesTargetForExpectedAmount(){

        //Hago un mock del tablero
        Board boardMock = mock(Board.class);
        UtilBoard utilBoard = mock(UtilBoard.class);
        Cell cell = mock(Cell.class);
        Cell nextCell = mock(Cell.class);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(19);
        when(nextCell.getYPosition()).thenReturn(19);

        Unit catapult = new Catapult();
        Unit target = new TestDummy();
        catapult.setCell(nextCell);
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

    @Test
    void Test02CatapultCantAtackBecauseOfTheShortDistance(){

        //Hago un mock del tablero
        Board boardMock = mock(Board.class);
        UtilBoard utilBoard = mock(UtilBoard.class);
        Cell cell = mock(Cell.class);
        Cell nextCell = mock(Cell.class);

        when(cell.getXPosition()).thenReturn(0);
        when(cell.getYPosition()).thenReturn(0);

        when(nextCell.getXPosition()).thenReturn(1);
        when(nextCell.getYPosition()).thenReturn(1);

        Unit catapult = new Catapult();
        Unit target = new TestDummy();
        catapult.setCell(nextCell);
        target.setCell(cell);//asigno a la unidad objetivo la celda objetivo
        catapult.setBoard(boardMock);//asigno el tablero mockeado a la catapulta

        //Genero un set vacio para que simule el mock
        Set<Unit> affectedUnits = new HashSet<>();

        //Le indico al mock del tablero que cuando le pregunten que unidadades rodean a la celda afectada devuelva vacio
        when(boardMock.getNearbyUnits(cell)).thenReturn(affectedUnits);

        assertThrows(AbilityException.class, () -> {
            catapult.useAbility(target);
        });
    }

    @Test
    void Test03CatapultCantMoveAndCantBeHeal() {
        Unit catapult = new Catapult();
        Cell cell = mock(Cell.class);

        assertThrows(MovementException.class, () -> {
            catapult.moveTo(cell);
        });
        assertFalse(catapult.canBeHealed());
    }

}