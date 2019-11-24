package Vista;

import Controladores.CellController;
import javafx.scene.layout.Pane;

public class CellView extends Pane {
    private int positionX;
    private int positionY;
    private CellController controller;

    public CellView(int x, int y) {
        positionX = x;
        positionY = y;
        setOnMouseClicked(e -> {
            System.out.println(positionX + " " + positionY);
        });
    }

}
