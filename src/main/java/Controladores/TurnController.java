package Controladores;

import Modelo.Player;
import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import Vista.popUp.AlertPopUpWindow;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javax.swing.*;
import java.util.ArrayList;

public class TurnController implements EventHandler<ActionEvent> {

    private ArrayList<Player> players;
    private Player actualPlayer;
    private Player nextPlayer;
    private static TurnController controller;
    private Unit setUnit;
    private static GameSystemController gameSystemController = GameSystemController.getInstance();
    private boolean firstPlayerFinish = false;
    private boolean secondPlayerFinish = false;

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
        if (!firstPlayerFinish) {
            if (actualPlayer.getUnitsAmount() == 0) {
                new AlertPopUpWindow()
                        .display("Game Over", "Player " + actualPlayer.getName() + " loose");
                Platform.exit();
            }
            firstPlayerFinish = true;
        } else if (!secondPlayerFinish) {
            if (actualPlayer.getUnitsAmount() == 0) {
                new AlertPopUpWindow()
                        .display("Game Over", "Player " + actualPlayer.getName() + " loose");
                Platform.exit();
            }
            secondPlayerFinish = true;
        }
        this.changeTurn();
        System.out.println("Es el turno de: " + actualPlayer.getName());
    }

    public void changeTurn() {
        // Logica barata para cambiar el turno
        Player swap = actualPlayer;
        actualPlayer = nextPlayer;
        nextPlayer = swap;

        if (gameSystemController.getLastCellView() != null) gameSystemController.getLastCellView().unHighlightUnit();
        gameSystemController.changeTurn();
    }

    public boolean getFirstPlayerFinish() {
        return firstPlayerFinish;
    }

    public boolean getSecondPlayerFinish() {
        return secondPlayerFinish;
    }
}
