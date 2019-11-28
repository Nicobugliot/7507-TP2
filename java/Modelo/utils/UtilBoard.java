package Modelo.utils;

import Modelo.Cell;

public class UtilBoard {

    public static Integer distanceBetweenCells(Cell actualCell, Cell nextCell) {
        Integer actualX = actualCell.getXPosition();
        Integer actualY = actualCell.getYPosition();
        Integer nextX = nextCell.getXPosition();
        Integer nextY = nextCell.getYPosition();

        Integer distance = Math.max(Math.abs(nextX - actualX), Math.abs(nextY - actualY));

        return distance;
    }
}
