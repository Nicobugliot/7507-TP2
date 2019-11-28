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
                Unit soldier = new InfantrySoldier();
                actualPlayer.addUnit(soldier);
                turnController.setUnit(soldier);
                System.out.println("Pone la unidad...");
                break;
            case "Rider":
                Unit rider = new Rider();
                actualPlayer.addUnit(rider);
                turnController.setUnit(rider);
                System.out.println("Pone la unidad...");
                break;
            case "Healer":
                Unit healer = new Healer();
                actualPlayer.addUnit(healer);
                turnController.setUnit(healer);
                System.out.println("Pone la unidad...");
                break;
            case "Catapult":
                Unit catapult = new Catapult();
                actualPlayer.addUnit(catapult);
                turnController.setUnit(catapult);
                System.out.println("Pone la unidad...");
                break;
        }
    }
}
