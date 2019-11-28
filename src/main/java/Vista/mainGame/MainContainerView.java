package Vista.mainGame;

import Controladores.TurnController;
import Modelo.Player;
import Vista.mainGame.BoardView;
import Vista.mainGame.PlayerView;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class MainContainerView extends StackPane{

    private ArrayList<Player> players;
    private Stage stage;

    public MainContainerView() {

        // Load player
        this.players = TurnController.getInstance().getPlayers();

        // Load your Image
        ImageView backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/tablero.png")));

        PlayerView firstPlayerView = new PlayerView(players.get(0).getName(), Color.RED, players.get(0).getPoints());
        
        PlayerView secondPlayerView = new PlayerView(players.get(1).getName(), Color.BLUE, players.get(1).getPoints());

        BoardView boardView = new BoardView();

        this.setMinWidth(500);
        this.setMinHeight(600);

        this.getChildren().addAll(backgroundImageView, boardView, firstPlayerView, secondPlayerView);
        this.setAlignment(firstPlayerView, Pos.TOP_CENTER);
        this.setAlignment(secondPlayerView, Pos.BOTTOM_CENTER);
    }
}
