package algoChess;

import board.Board;
import cell.Cell;
import player.Player;

public class AlgoChess {

    private static Player firstPlayer;
    private static Player secondPlayer;
    private static Board board = Board.getBoard();

    public AlgoChess() {
    }


    public void addPlayer(Player player) {
        if (firstPlayer == null) {
            this.firstPlayer = player;
        }else if(secondPlayer == null){
            this.secondPlayer = player;
        }
        //TODO si ya estan los dos jugadores entonces que no deje crear mas
    }

    public Cell getCell(Integer positionX, Integer positionY){
        return board.getCell(positionX, positionY);
    }
}
