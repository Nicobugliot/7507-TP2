package Vista;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Cell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BoardView implements EventHandler<ActionEvent> {

    // the dimensions of our background Image
    private final int BORDER_WIDTH = 500;
    private final int BORDER_HEIGHT = 500;

    public void startGame() throws Exception {
        Stage stage = new Stage();

        stage.setMinWidth(500);
        stage.setMinHeight(600);

        // Load your Image
        ImageView backgroundImageView = new ImageView(
                new Image(getClass().getResourceAsStream("/tablero.png")));
        // Initialize the grid
        GridPane boardGrid = initBoard();
        // Set the dimensions of the grid
        boardGrid.setPrefSize(BORDER_WIDTH, BORDER_HEIGHT);
        boardGrid.setAlignment(Pos.CENTER);

        // Use a StackPane to display the Image and the Grid
        StackPane mainPane = new StackPane();
        mainPane.getChildren().addAll(backgroundImageView, boardGrid);

        stage.setScene(new Scene(mainPane));
        stage.setResizable(false);
        stage.showAndWait();

    }

    private GridPane initBoard() {
        GridPane boardGrid = new GridPane();

        //file path
        String path = "/celda_roja.png";

        // create a image
        Image image = new Image(getClass().getResourceAsStream(path));

        // create a background image
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);


        int tileNum = 20;
        double tileWidth = BORDER_WIDTH / tileNum;
        double tileHeight = BORDER_HEIGHT / tileNum;

        for (int i = 0; i < tileNum; i++) {
            for (int j = 0; j < tileNum; j++) {
                Tile tile = new Tile(i, j);
                tile.setBackground(Background.EMPTY);
                // Set each 'Tile' the width and height
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

    class Tile extends Pane {
        private int positionX;
        private int positionY;

        public Tile(int x, int y) {
            positionX = x;
            positionY = y;
            setOnMouseClicked(e -> {
                System.out.println(positionX + " " + positionY);

            });
        }
    }
}