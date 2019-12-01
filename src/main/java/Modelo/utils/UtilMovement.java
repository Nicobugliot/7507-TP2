package Modelo.utils;

import Modelo.Board;
import Modelo.Cell;

public class UtilMovement {

    public static Boolean unitCanMove(Cell actualCell, Cell nextCell){
        Integer xPosition = actualCell.getXPosition();
        Integer yPosition = actualCell.getYPosition();

        for (Integer row = yPosition - 1; row <= yPosition + 1; row++) {
            for (Integer column = xPosition - 1; column <= xPosition + 1; column++) {
                try {
                    if (( isSamePosition(row, column, nextCell) ) &&
                            (! (row == yPosition && column == xPosition) )) {
                        return true;
                    }
                }catch (ArrayIndexOutOfBoundsException err) {

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
