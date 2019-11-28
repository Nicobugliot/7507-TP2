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
            board.getCell(xPosition, yPosition).setUnit(unit);
            addUnit(unit.getType().toString(), actualPlayer.getTeam().toString());
        } else {
            System.out.println(xPosition + " " + yPosition);
        }
    }

    public void addUnit(String unitName, String teamName) {
        Player actualPlayer = turnController.getActualPlayer();
        String color = actualPlayer.getTeam() == 0  ? "rojo" : "azul";
        System.out.println(unitName + "_" + color + ".png");
        cellView.updateImage(unitName + "_" + color + ".png");
        turnController.unitHasBeenSet();
    }
}
