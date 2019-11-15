package test;

import board.Board;
import cell.Cell;
import exceptions.OccupiedCellException;
import masterhand.MasterHand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class BoardUnitTest {

    private Cell cell = mock(Cell.class);

    @Test
    public void Test00InitializeABoardIsOK() {
        Board board = Board.getBoard();

        Cell cell = board.getCell(1, 1);

        assertTrue(cell != null);
    }

    @Test
    public void Test01InitializeAnUnitInAnOccupiedCell() {
        Board board = Board.getBoard();

        doThrow(new OccupiedCellException("La celda está ocupada")).when(cell).setUnit(any());

        assertThrows(OccupiedCellException.class, () -> {
            board.initializeUnit(any(), cell);
        });
    }

    @Test
    public void Test02InitializeAnUnitInAnEmptyCell() {
        Board board = Board.getBoard();

        board.initializeUnit(any(), cell);

        verify(cell, times(1)).setUnit(any());
    }



}
