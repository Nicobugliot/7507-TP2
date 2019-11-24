package Controladores;

import Modelo.Board;
import Modelo.Cell;
import Vista.BoardView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class CellController implements EventHandler<MouseEvent> {

    private final Integer yPosition;
    private final Integer xPosition;
    private Board board = Board.getBoard();

    public CellController(Integer y, Integer x) {
        this.yPosition = y;
        this.xPosition = x;
    }

    @Override
    public void handle(MouseEvent event) {

    }
}
