package test;

import cell.Cell;
import exceptions.OccupiedCellException;
import masterhand.MasterHand;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


public class MasterHandUnitTest {

    private Cell cell = mock(Cell.class);
    private MasterHand masterHand = new MasterHand();

    @Test
    public void Test01InitializeAnUnitInAnOccupiedCell() {
        doThrow(new OccupiedCellException("La celda está ocupada")).when(cell).initializeUnit(any(), any());

        assertThrows(OccupiedCellException.class, () -> {
            masterHand.initializeUnit(any(), any(), cell);
        });
    }

    @Test
    public void Test02InitializeAnUnitInAnEmptyCell() {
        masterHand.initializeUnit(any(), any(), cell);

        verify(cell, times(1)).initializeUnit(any(), any());
    }

}