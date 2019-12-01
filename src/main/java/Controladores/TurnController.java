package Controladores;

import Modelo.Player;
import Modelo.unit.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.ArrayList;

public class TurnController implements EventHandler<ActionEvent> {

    private ArrayList<Player> players;
    private Player actualPlayer;
    private Player nextPlayer;
    private static TurnController controller;
    private Unit setUnit;
    private Unit setUnitAbility;
    private Unit unitMoveTo;
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

    public void setUnitAbility(Unit unit) {
        this.setUnitAbility = unit;
    }

    public Unit getUnitAbility() {
        return this.setUnitAbility;
    }

    public void unitAbilityHasBeenSet() {
        this.setUnitAbility = null;
    }

    @Override
    public void handle(ActionEvent event) {
        this.changeTurn();
        System.out.println("Es el turno de: " + actualPlayer.getName());
    }

    public void changeTurn() {
        // Logica barata para cambiar el turno
        Player swap = actualPlayer;
        actualPlayer = nextPlayer;
        nextPlayer = swap;

        gameSystemController.changeTurn();
    }
}
