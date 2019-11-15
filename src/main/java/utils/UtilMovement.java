package utils;

import board.Board;
import cell.Cell;
import exceptions.MovementException;

public class UtilMovement {

    public static Boolean unitCanMove(Cell actualCell, Cell nextCell){
        Integer xPosition = actualCell.getXPosition();
        Integer yPosition = actualCell.getYPosition();
        Board board = Board.getBoard();

        for (Integer row = yPosition - 1; row <= yPosition + 1; row++) {
            for (Integer column = xPosition - 1; column <= xPosition + 1; column++) {
                try {
                    if (( isSamePosition(row, column, nextCell) ) &&
                            (! (row == yPosition && column == xPosition) )) {
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException err) {
                    System.out.println(err);
                }
            }
        }
        return false;
    }


    private static Boolean isSamePosition(Integer yPosition, Integer xPosition, Cell nextCell) {
        return ((xPosition == nextCell.getXPosition()) &&
                (yPosition == nextCell.getYPosition()));
    }

}
