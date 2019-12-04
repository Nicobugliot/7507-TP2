package Vista.mainGame;
import Controladores.GameSystemController;
import javafx.geometry.Pos;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;

public class BoardView extends GridPane {

    // the dimensions of our background Image
    private static GameSystemController gameSystemController = GameSystemController.getInstance();
    private final int BORDER_WIDTH = 800;
    private final int BORDER_HEIGHT = 800;

    public BoardView() {

        int tileNum = 20;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;

        for (int i = 0; i < tileNum; i++) {
            for (int j = 0; j < tileNum; j++) {
                CellView tile = new CellView(i, j);
                gameSystemController.setCellViews(j, i, tile);
                tile.setBackground(Background.EMPTY);
                tile.setPrefSize(tileWidth, tileHeight);

                // Add node on j column and i row
                this.add(tile, j, i);
            }
        }

        // Set the dimensions of the grid
        this.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);
        this.setAlignment(Pos.CENTER);

    }

}