package board;

import cell.Cell;
import cell.AlliedCell;

public class Board {

    private static Board board = new Board();
    private static Cell[][] boardCells = new Cell[20][20];

    private Board() { }

    public static Board getBoard(){
        for(int i = 0; i < boardCells.length; i++){
            for(int j = 0; j < boardCells.length; j++){
                boardCells[i][j] = new AlliedCell(i, j);
            }
        }
        return board;
    }

    public Cell getCell(Integer positionX, Integer positionY){
        Cell cell = boardCells[positionX][positionY];
        return cell;
    }

    public Boolean cellIsEmpty(Integer xPosition, Integer yPosition){
        return boardCells[xPosition][yPosition]
                .isEmpty();
    }

}
