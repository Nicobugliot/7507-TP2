package Controladores;

import Modelo.Board;
import Modelo.Player;
import Modelo.unit.Unit;
import Modelo.unit.UnitType;
import Vista.mainGame.CellView;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController {

    private final Integer yPosition;
    private final Integer xPosition;
    private Board board = Board.getBoard();
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
            unit.setTeam(actualPlayer.getTeam());
            System.out.println(board.getCell(xPosition, yPosition));
            System.out.println(board.getCell(xPosition, yPosition).getTeam());
            actualPlayer.initializeUnit(unit, board.getCell(xPosition, yPosition));
            addUnitToBoard(unit.getType().toString());
        } else {
            System.out.println(xPosition + " " + yPosition);
        }
    }

    private void addUnitToBoard(String unitName) {
        Player actualPlayer = turnController.getActualPlayer();
        String color = actualPlayer.getTeam() == 0  ? "rojo" : "azul";
        System.out.println(unitName + "_" + color + ".png");
        cellView.updateImage(unitName + "_" + color + ".png");
        turnController.unitHasBeenSet();
    }
}
