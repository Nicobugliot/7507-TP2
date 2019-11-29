package Controladores;

import Modelo.Board;
import Modelo.Player;
import Modelo.exceptions.MovementException;
import Modelo.unit.Unit;
import Modelo.unit.UnitType;
import Vista.mainGame.CellView;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController {

    private final Integer yPosition;
    private final Integer xPosition;
    private static Board board = Board.getBoard();
    private TurnController turnController = TurnController.getInstance();
    private CellView cellView;

    public CellController(Integer x, Integer y, CellView cellView) {
        this.xPosition = x;
        this.yPosition = y;
        this.cellView = cellView;
    }

    public void handleClick() {
        Player actualPlayer = turnController.getActualPlayer();
        Unit unit = turnController.getSetUnit();
        if (unit != null) {
            try {
                unit.setTeam(actualPlayer.getTeam());
                actualPlayer.initializeUnit(unit, board.getCell(xPosition, yPosition));
                addUnitToBoard(unit.getType().toString());
            } catch (MovementException err) {
                System.out.println("No se puede iniciar una unidad en celda enemiga");
            }
        } else {
            System.out.println(xPosition + " " + yPosition);
        }
    }

    private void addUnitToBoard(String unitName) {
        Player actualPlayer = turnController.getActualPlayer();
        String color = actualPlayer.getTeam() == 0  ? "rojo" : "azul";
        cellView.updateImage(unitName + "_" + color + ".png");
        turnController.unitHasBeenSet();
    }
}
