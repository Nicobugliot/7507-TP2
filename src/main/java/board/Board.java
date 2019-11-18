package board;

import cell.Cell;
import masterhand.MasterHand;
import player.Player;
import unit.Unit;

import java.util.HashSet;
import java.util.Set;

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
        return board;
    }

    public Cell getCell(Integer positionX, Integer positionY){
        Cell cell = boardCells[positionX][positionY];
        return cell;
    }

    public void setBoardCells(Player firstPlayer, Player secondPlayer) {
        for(int i = 0; i < boardCells.length / 2; i++){
            for(int j = 0; j < boardCells.length; j++){
                boardCells[i][j].setPlayer(firstPlayer);
                boardCells[i + (boardCells.length / 2)][j].setPlayer(secondPlayer);
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
    private Set<Cell> findNeighborCells(int x, int y)
    {
        Set<Cell> neighbourCells = new HashSet<>();
        try
        {
            try { neighbourCells.add(boardCells[x][y - 1]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x - 1][y - 1]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x - 1][y]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x - 1][y + 1]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x][y + 1]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x + 1][y + 1]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x + 1][y]); }
            catch (Exception e) {}
            try { neighbourCells.add(boardCells[x + 1][y - 1]); }
            catch (Exception e) {}
        }
        catch (Exception e)
        {
            // exception caused due to position non-existing in matrix.
        }
        finally
        {
            return neighbourCells;
        }
    }
}
