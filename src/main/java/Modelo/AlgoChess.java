package Modelo;

public class AlgoChess {

    private static Player firstPlayer;
    private static Player secondPlayer;
    private static Board board = Board.getBoard();

    public AlgoChess() {
    }


    public void addPlayer(Player player) {
        if (firstPlayer == null) {
            player.setTeam(1);
            this.firstPlayer = player;
        }else if(secondPlayer == null){
            player.setTeam(2);
            this.secondPlayer = player;
        }
        //TODO si ya estan los dos jugadores entonces que no deje crear mas
    }

    public Cell getCell(Integer positionX, Integer positionY){
        return board.getCell(positionX, positionY);
    }

    public void setBoard(Player firstPlayer, Player secondPlayer) {
        board.setBoardCells(firstPlayer, secondPlayer);
    }
}
