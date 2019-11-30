package Controladores;

import Modelo.Player;
import Modelo.unit.Unit;
import Vista.mainGame.PlayerView;
import Vista.mainGame.UnitView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class TurnController implements EventHandler<ActionEvent> {

    private ArrayList<Player> players;
    private Player actualPlayer;
    private Player nextPlayer;
    private PlayerView actualPlayerView;
    private PlayerView nextPlayerView;
    private static TurnController controller;
    private Unit setUnit;
    private UnitView unitView;
    private static GameSystemController gameSystemController = GameSystemController.getInstance();

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

    public void setUnit(Unit unit) {
        setUnit = unit;
    }

    public Unit getSetUnit() {
        return setUnit;
    }

    public void unitHasBeenSet() {
        setUnit = null;
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

        gameSystemController.changeTurn();
    }
}
