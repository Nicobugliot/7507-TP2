package Controladores.Botones;

import Controladores.GameSystemController;
import Modelo.unit.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AbilityController implements EventHandler<ActionEvent> {

    private static Unit unit;
    private static GameSystemController gameSystemController = GameSystemController.getInstance();


    public AbilityController(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameSystemController.setUnitAbility(unit);
    }
}
