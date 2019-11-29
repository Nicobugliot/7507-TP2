package Controladores;

import Modelo.Player;
import Modelo.unit.Unit;
import Vista.mainGame.PlayerView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class TurnController implements EventHandler<ActionEvent> {

    private ArrayList<Player> players;
    private ArrayList<PlayerView> playerViews;
    private Player actualPlayer;
    private Player nextPlayer;
    private PlayerView actualPlayerView;
    private PlayerView nextPlayerView;
    private static TurnController controller;
    private Unit setUnit;

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

    public void setPlayerViews(PlayerView firstPlayerView, PlayerView secondPlayerView) {
        ArrayList<PlayerView> playerViews = new ArrayList<PlayerView>();
        playerViews.add(firstPlayerView);
        playerViews.add(secondPlayerView);

        actualPlayerView = firstPlayerView;
        actualPlayerView.turnView();
        nextPlayerView = secondPlayerView;
        nextPlayerView.notTurnView();git
    }

    @Override
    public void handle(ActionEvent event) {
        this.changePlayer();
        System.out.println("Es el turno de: " + actualPlayer.getName());
    }

    public void refreshPlayerView() {
        actualPlayerView.refreshPoints();
    }

    private void changePlayer() {
        // Logica barata para cambiar el turno
        Player swap = actualPlayer;
        actualPlayer = nextPlayer;
        nextPlayer = swap;

        PlayerView swapView = actualPlayerView;
        actualPlayerView = nextPlayerView;
        nextPlayerView = swapView;

        actualPlayerView.turnView();
        nextPlayerView.notTurnView();
    }
}
