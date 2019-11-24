package Controladores.Botones;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class AddUnitController implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        System.out.println(event.getEventType());
    }
}
