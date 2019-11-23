package Modelo;

import Modelo.exceptions.GameErrorException;

import java.util.Random;

public class AlgoChess {

    private static Board board = Board.getBoard();
    private Integer MAX_PLAYERS = 2;
    private Player[] players = new Player[MAX_PLAYERS+1];
    private Integer playersAdded = 0;
    private Integer actingTeam;
    private Boolean GAME_OVER = false;

    public AlgoChess() {
    }

    /*Función para agregar jugadores, permite un máximo de MAX_PLAYERS jugadores y le asigna a cada jugador su posición
    en el arreglo como equipo, es decir el primer jugador agregado tiene el equipo 1, omite la posición 0
     */
    public void addPlayer(Player player) throws GameErrorException {
        if (playersAdded == MAX_PLAYERS) throw new GameErrorException("Max amount of players reached");
        else{
            ++playersAdded; //así el jugador 1 esta en la posición 1
            player.setTeam(playersAdded);
            players[playersAdded] = player;
        }
    }

    public Cell getCell(Integer positionX, Integer positionY){
        return board.getCell(positionX, positionY);
    }

    public void setBoard(Player firstPlayer, Player secondPlayer) {
        board.setBoardCells(firstPlayer, secondPlayer);
    }

    public void startGame(){
        Integer startingTeam = (new Random()).nextInt(2) + 1;//un número al azar de 0 a 2, le sumo uno para que represente los equipos 1 y 2
        this.actingTeam  = startingTeam;
        Integer nextTeam = ++startingTeam % (MAX_PLAYERS+1);
        while(!GAME_OVER){
            this.actingTeam  = nextTeam;
            nextTeam = ++actingTeam % (MAX_PLAYERS+1);
            actingTeam = (actingTeam != 0 ? actingTeam : ++actingTeam); //no hay jugador 0
        }
    }
}
