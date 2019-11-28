package Controladores;

import Modelo.Board;
import Modelo.Player;
import Modelo.unit.Unit;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController {

    private final Integer yPosition;
    private final Integer xPosition;
    private Board board = Board.getBoard();
    private TurnController turnController = TurnController.getInstance();

    public CellController(Integer y, Integer x) {
        this.yPosition = y;
        this.xPosition = x;
    }

    public void handleClick() {
        Player actualPlayer = turnController.getActualPlayer();
        Unit unit = turnController.getSetUnit();
        if (unit != null) {
            //actualPlayer.initializeUnit(unit, board.getCell(xPosition, yPosition));
            System.out.println(unit);
            System.out.println(board.getCell(xPosition, yPosition));
            System.out.println(actualPlayer.getTeam());
        }
    }
}
