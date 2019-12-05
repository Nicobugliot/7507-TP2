package Modelo;

import Modelo.unit.Unit;

import java.util.HashSet;
import java.util.Set;

import static Modelo.utils.UtilBoard.distanceBetweenCells;

public class Board {

    private static Board board;
    private static Cell[][] boardCells = new Cell[20][20];

    private Board() { }

    public static Board getBoard(){
        if (board == null){
            board = new Board();
        }

        for(int i = 0; i < boardCells.length; i++){
            for(int j = 0; j < boardCells.length; j++){
                boardCells[i][j] = new Cell(i, j);
            }
        }
        setBoardCells();
        return board;
    }

    public Cell getCell(Integer positionX, Integer positionY){
        Cell cell = boardCells[positionX][positionY];
        return cell;
    }

    public static void setBoardCells() {
        for(int i = 0; i < boardCells.length / 2; i++){
            for(int j = 0; j < boardCells.length; j++){
                boardCells[i][j].setTeam(0);
                boardCells[i + (boardCells.length / 2)][j].setTeam(1);
            }
        }
    }

    /*Returns a boolean indicating the presence of allies in the neighbor cells*/
    public boolean alliesNearby(Cell cell, Integer team) {
        int xPos = cell.getXPosition();
        int yPos = cell.getYPosition();
        Set<Cell> neighbourCells = findNeighborCells(xPos, yPos);

        for (Cell neighbourCell : neighbourCells){
            if (!neighbourCell.isEmpty() && neighbourCell.containsAllyOf(team)) return true;
        }
        return false;
    }

    /*Returns a boolean indicating the presence of enemies in the neighbor cells*/
    public boolean enemiesNearby(Cell cell, Integer team) {
        int xPos = cell.getXPosition();
        int yPos = cell.getYPosition();
        Set<Cell> neighbourCells = findNeighborCells(xPos, yPos);

        for (Cell neighbourCell : neighbourCells){
            if (!neighbourCell.isEmpty() && !neighbourCell.containsAllyOf(team)) return true;
        }
        return false;
    }

    public Set<Unit> getNearbyUnits(Cell cell) {
        int xPos = cell.getXPosition();
        int yPos = cell.getYPosition();
        Set<Cell> neighbourCells = findNeighborCells(xPos, yPos);
        Set<Unit> neighbourUnits = new HashSet<>();

        for (Cell neighbourCell : neighbourCells){
            if (!neighbourCell.isEmpty()) neighbourUnits.add(neighbourCell.getUnit());
        }

        return neighbourUnits;
    }

    /*Finds the neighbour cells if possible surrrounding a given position*/
    private Set<Cell> findNeighborCells(int x, int y) {
        Set<Cell> neighbourCells = new HashSet<>();
        for (Integer row = y - 1; row <= y + 1; row++) {
            for (Integer column = x - 1; column <= x + 1; column++) {
                try {
                    if (!((row == y) && (column == x))) {
                        neighbourCells.add(boardCells[row][column]);
                    }
                } catch (ArrayIndexOutOfBoundsException err) { }
            }
        }
        return neighbourCells;
    }

    public boolean alliesInShortRange(Cell cell, Integer team) {
        Set<Cell> shortRangeCells = findCellsInRangeFromCell(2, cell);

        for (Cell shortRangeCell : shortRangeCells){
            if (!shortRangeCell.isEmpty() && shortRangeCell.containsAllyOf(team)) return true;
        }
        return false;
    }

    public boolean enemiesInShortRange(Cell cell, Integer team) {
        Set<Cell> shortRangeCells = findCellsInRangeFromCell(2, cell);

        for (Cell shortRangeCell : shortRangeCells){
            if (!shortRangeCell.isEmpty() && !shortRangeCell.containsAllyOf(team)) return true;
        }
        return false;
    }

    private Set<Cell> findCellsInRangeFromCell(int range, Cell centralCell) {
        Set<Cell> cellsInRange = new HashSet<>();
        for (Cell[] column: boardCells) {
            for (Cell cell: column){
                if (distanceBetweenCells(centralCell, cell) <= range) cellsInRange.add(cell);
            }
        }
        return cellsInRange;
    }
}
