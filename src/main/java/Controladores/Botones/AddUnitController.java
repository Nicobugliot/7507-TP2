package Controladores.Botones;

import Controladores.GameSystemController;
import Controladores.TurnController;
import Modelo.Player;
import Modelo.exceptions.MovementException;
import Modelo.unit.*;
import Modelo.exceptions.InsufficientPointsException;
import Vista.popUp.AlertPopUpWindow;
import Vista.popUp.BuyUnitPopUpWindow;
import Vista.popUp.ConfirmationPopUpWindow;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AddUnitController implements EventHandler<ActionEvent> {

    private String unit;
    private Player actualPlayer;
    private static TurnController turnController = TurnController.getInstance();
    private static GameSystemController gameSystemController = GameSystemController.getInstance();

    public AddUnitController(String unit) {
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent event) {
        this.actualPlayer = turnController.getActualPlayer();
        switch (unit){
            case "Soldier":
                //buyUnit(new InfantrySoldier());
                buyConfirmation();
                break;
            case "Rider":
                buyUnit(new Rider());
                break;
            case "Healer":
                buyUnit(new Healer());
                break;
            case "Catapult":
                buyUnit(new Catapult());
                break;
        }
    }

    private void buyUnit(Unit unit) {
        if (turnController.getSetUnit() == null) {
            try {
                actualPlayer.addUnit(unit);
                turnController.setUnit(unit);
                gameSystemController.refreshPlayerView();
            } catch (InsufficientPointsException err) {
                new AlertPopUpWindow()
                        .display("Money exception", err.getMessage());
            }
        } else {
            new AlertPopUpWindow()
                    .display("Move Exception", "Tenes que ubicar la pieza primero");;
        }
    }

    private void buyConfirmation(){
        BuyUnitPopUpWindow confirmBuy = new BuyUnitPopUpWindow();
        boolean wantedToBuy = confirmBuy.display(
                "HP : 100",
                "Cost: 1",
                "Ability Description: Melee Damage : 10",
                "Special Behaviour: Can form Battalions");
        if (wantedToBuy) buyUnit(new InfantrySoldier());
    }
}
