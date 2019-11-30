package Vista.mainGame;
import javafx.geometry.Pos;
import javafx.scene.layout.*;

public class BoardView extends GridPane {

    // the dimensions of our background Image
    private final int BORDER_WIDTH = 800;
    private final int BORDER_HEIGHT = 800;

    public BoardView() {

        int tileNum = 20;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;

        for (int i = 0; i < tileNum; i++) {
            for (int j = 0; j < tileNum; j++) {
                CellView tile = new CellView(i, j);
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