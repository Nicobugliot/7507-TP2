package Controladores;

import Modelo.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class TurnController implements EventHandler<ActionEvent> {

    private ArrayList<Player> players;
    private Player actualPlayer;
    private static TurnController controller;
    private Player nextPlayer;

    public static TurnController getInstance(){
        if (controller == null){
            controller = new TurnController();
        }
        return controller;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public Player getActualPlayer() {
        return actualPlayer;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void startGame() {
        // Elijo el primer jugador
        this.actualPlayer = players.get(0);
        this.nextPlayer = players.get(1);
        System.out.println("Es el turno de " + actualPlayer.getName());
    }

    @Override
    public void handle(ActionEvent event) {
        this.changePlayer();
        System.out.println("Es el turno de: " + actualPlayer.getName());
    }

    private void changePlayer() {
        // Logica barata para cambiar el turno
        Player swap = actualPlayer;
        actualPlayer = nextPlayer;
        nextPlayer = swap;
    }
}
