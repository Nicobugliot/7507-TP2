package Controladores.Botones;

import Controladores.TurnController;
import Modelo.Player;
import Modelo.unit.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AddUnitController implements EventHandler<ActionEvent> {

    private String unit;
    private Player actualPlayer;
    private static TurnController turnController = TurnController.getInstance();

    public AddUnitController(String unit) {
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent event) {
        this.actualPlayer = turnController.getActualPlayer();
        switch (unit){
            case "Soldier":
                buyUnit(new InfantrySoldier());
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
            turnController.setUnit(unit);
            actualPlayer.addUnit(unit);
        } else {
            System.out.println("Tenes que ubicar la pieza.");
        }
    }
}
