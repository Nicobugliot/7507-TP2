package Controladores;

import Modelo.Player;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class TurnController {

    private ArrayList<Player> players;
    private Player actualPlayer;
    private static TurnController controller;

    public static TurnController getInstance(){
        if (controller == null){
            controller = new TurnController();
        }
        return controller;
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public void startGame() {
        // Elijo el primer jugador
        this.actualPlayer = players.get(0);
        System.out.println("Es el turno de " + actualPlayer.getName());
    }

    public void changePlayer() {
        // Logica barata para cambiar el turno
        if (this.actualPlayer == players.get(0)) {
            this.actualPlayer = players.get(1);
        } else {
            this.actualPlayer = players.get(0);
        }
    }

}
