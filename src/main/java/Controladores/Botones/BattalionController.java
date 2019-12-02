package Controladores.Botones;

import Controladores.GameSystemController;
import Modelo.unit.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BattalionController implements EventHandler<ActionEvent> {


    private Unit unit;
    private static GameSystemController gameSystemController = GameSystemController.getInstance();

    public BattalionController(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent event) {
        gameSystemController.setBattalionLeader(unit);
    }
}
