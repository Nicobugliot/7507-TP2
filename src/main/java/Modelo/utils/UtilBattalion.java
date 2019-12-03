package Modelo.utils;

import Modelo.Board;
import Modelo.Cell;

public class UtilBattalion {

    private static int movementX;
    private static int movementY;
    private static Board board = Board.getBoard();

    public static void calculateMovementDirection(Cell actualCell, Cell nextCell) {
        Integer actualX = actualCell.getXPosition();
        Integer actualY = actualCell.getYPosition();
        Integer nextX = nextCell.getXPosition();
        Integer nextY = nextCell.getYPosition();

        movementX = (nextX - actualX);
        movementY = (nextY - actualY);
    }

    public static Cell calculateNextCellFor(Cell cellA) {
        Integer xPosition = cellA.getXPosition();
        Integer yPosition = cellA.getYPosition();
        return  (board.getCell(xPosition + movementX , yPosition + movementY));
    }
}