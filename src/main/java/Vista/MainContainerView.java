package Vista;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class MainContainerView extends StackPane{

    public MainContainerView(String[] players) {
        // Load your Image
        ImageView backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/tablero.png")));

        PlayerView firstPlayerView = new PlayerView(players[0], Color.RED);
        PlayerView secondPlayerView = new PlayerView(players[1], Color.BLUE);

        BoardView boardView = new BoardView();

        this.setMinWidth(500);
        this.setMinHeight(600);

        this.getChildren().addAll(backgroundImageView, boardView, firstPlayerView, secondPlayerView);
        this.setAlignment(firstPlayerView, Pos.TOP_CENTER);
        this.setAlignment(secondPlayerView, Pos.BOTTOM_CENTER);
    }
}
