package Vista.mainGame;

import Controladores.TurnController;
import Modelo.Player;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainContainerView extends StackPane{

    private ArrayList<Player> players;
    private TurnController turnController = TurnController.getInstance();
    private Stage stage;

    public MainContainerView() {
        // Load player
        this.players = turnController.getPlayers();

        // Load your Image
        ImageView backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/tablero.png")));

        PlayerView firstPlayerView = new PlayerView(players.get(0), Color.RED);
        PlayerView secondPlayerView = new PlayerView(players.get(1), Color.BLUE);

        turnController.setPlayerViews(firstPlayerView, secondPlayerView);

        BoardView boardView = new BoardView();

        this.setMinWidth(500);
        this.setMinHeight(600);

        this.getChildren().addAll(backgroundImageView, boardView, firstPlayerView, secondPlayerView);
        this.setAlignment(firstPlayerView, Pos.TOP_CENTER);
        this.setAlignment(secondPlayerView, Pos.BOTTOM_CENTER);
    }
}
