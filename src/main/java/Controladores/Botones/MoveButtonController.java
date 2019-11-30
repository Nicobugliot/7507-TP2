package Controladores.Botones;

import Modelo.unit.Unit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveButtonController implements EventHandler<ActionEvent> {

    private static Unit unit;

    public MoveButtonController(Unit unit) {
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
