package Vista.mainGame;

import Controladores.CellController;
import Modelo.Cell;
import javafx.scene.layout.Pane;

import java.awt.event.MouseEvent;

public class CellView extends Pane {
    private int positionX;
    private int positionY;
    private CellController controller;

    public CellView(int x, int y) {
        positionX = x;
        positionY = y;
        controller = new CellController(x, y);
        this.setOnMouseClicked(e -> {
            controller.handleClick();
        });
    }

}
