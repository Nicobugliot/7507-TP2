package Controladores.Botones;


import Controladores.TurnController;
import Modelo.Board;
import Modelo.Player;
import Vista.mainGame.MainContainerView;
import Vista.scene.PreGameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.ArrayList;

public class PlayButtonController implements EventHandler<ActionEvent> {

    private Button startGameButton;
    private Stage stage;
    private static Board board = Board.getBoard();
    private static TurnController turnController = TurnController.getInstance();

    public PlayButtonController(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        // Inicio la carga de los nombres de los jugadores
        PreGameScene preGameScene = new PreGameScene();
        preGameScene.start();

        // Seteo el tablero
        ArrayList<Player> players = TurnController.getInstance().getPlayers();
        board.setBoardCells(players.get(0), players.get(1));
        System.out.println(players.get(0).getTeam());

        // Seteo el turno
        turnController.startGame();

        // Arranca el juego
        MainContainerView gameContainer = new MainContainerView();
        Scene gameScene = new Scene(gameContainer);
        stage.setScene(gameScene);
        stage.show();

    }

}


