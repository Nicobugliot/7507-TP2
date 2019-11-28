package Controladores;

import Modelo.Board;
import Modelo.Player;
import Modelo.unit.Unit;
import Modelo.unit.UnitType;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController {

    private final Integer yPosition;
    private final Integer xPosition;
    private Board board = Board.getBoard();
    private TurnController turnController = TurnController.getInstance();

    public CellController(Integer x, Integer y) {
        this.xPosition = x;
        this.yPosition = y;
    }

    public void handleClick() {
        Player actualPlayer = turnController.getActualPlayer();
        Unit unit = turnController.getSetUnit();
        if (unit != null) {
            unit.setTeam(actualPlayer.getTeam());
            board.getCell(xPosition, yPosition).setUnit(unit);
        }
    }

    public String getResource() {
        Player actualPlayer = turnController.getActualPlayer();
        String color = actualPlayer.getTeam() == 0  ?"rojo":"azul";
        Unit unit = board.getCell(xPosition, yPosition).getUnit();
        if(unit != null) {
            return unit.getType().toString() + "_" + color + ".png";
        } else {
            return "celda_" + color + ".png";
        }
    }
}
