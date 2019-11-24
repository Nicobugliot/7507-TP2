package Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class BoardView implements EventHandler<ActionEvent> {

    // the dimensions of our background Image
    private final int BORDER_WIDTH = 500;
    private final int BORDER_HEIGHT = 500;

    public StackPane setBoardView() {

        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image(getClass().getResourceAsStream("/tablero.png")));
        // Initialize the grid
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);

        // Use a StackPane to display the Image and the Grid
        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(backgroundImageView,
                boardGrid);

        return mainPane;
    }

    private GridPane initBoard() {
        GridPane boardGrid = new GridPane();

        int tileNum = 20;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;

        for (int i = 0; i < tileNum; i++) {
            for (int j = 0; j < tileNum; j++) {
                CellView tile = new CellView(i, j);
                tile.setBackground(Background.EMPTY);
                tile.setPrefSize(tileWidth, tileHeight);

                // Add node on j column and i row
                boardGrid.add(tile, j, i);
            }
        }
        // Return the GridPane
        return boardGrid;
    }

    @Override
    public void handle(ActionEvent event) {

    }
}