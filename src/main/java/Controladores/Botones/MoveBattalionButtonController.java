package Controladores.Botones;

import Controladores.GameSystemController;
import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MoveBattalionButtonController implements EventHandler<ActionEvent> {

    private static Unit unit;
    private CellView cellView;
    private static GameSystemController gameSystemController = GameSystemController.getInstance();

    public MoveBattalionButtonController(Unit unit, CellView cellView) {
        this.cellView = cellView;
        this.unit = unit;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        gameSystemController.setLastCellView(cellView);
        gameSystemController.setBattalionLeaderMoveTo(unit);
    }
}
