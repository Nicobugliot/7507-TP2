package Vista.mainGame;

import Controladores.GameSystemController;
import Controladores.TurnController;
import Modelo.Player;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;
import java.util.ArrayList;

public class GameContainerView extends StackPane{

    private ArrayList<Player> players;
    private TurnController turnController = TurnController.getInstance();
    private GameSystemController gameSystemController = GameSystemController.getInstance();

    public GameContainerView() {
        // Load player
        this.players = turnController.getPlayers();

        // Load your Image
        ImageView backgroundImageView = new ImageView(new Image(getClass().getResourceAsStream("/tablero.png")));
        backgroundImageView.setPreserveRatio(true);
        backgroundImageView.setFitHeight(800);

        /**
         * Vista de los jugadores
         */
        PlayerView firstPlayerView = new PlayerView(players.get(0), Color.valueOf("grey"));
        PlayerView secondPlayerView = new PlayerView(players.get(1), Color.valueOf("grey"));

        /**
         * Vista de las unidades
         */
        UnitView unitView = new UnitView();

        gameSystemController.setUnitView(unitView);
        gameSystemController.setPlayerViews(firstPlayerView, secondPlayerView);

        BoardView boardView = new BoardView();

        this.setMinWidth(1000);
        this.setMinHeight(1200);

        this.getChildren().addAll(backgroundImageView, boardView, firstPlayerView, secondPlayerView, unitView);
        this.setAlignment(unitView, Pos.CENTER_RIGHT);
        this.setAlignment(firstPlayerView, Pos.TOP_CENTER);
        this.setAlignment(secondPlayerView, Pos.BOTTOM_CENTER);


    }
}
