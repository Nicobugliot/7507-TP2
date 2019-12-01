package Controladores.Botones;


import Controladores.TurnController;
import Modelo.Board;
import Vista.mainGame.GameContainerView;
import Vista.scene.PreGameScene;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PlayButtonController implements EventHandler<ActionEvent> {

    private Stage stage;
    private Board board = Board.getBoard();
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
        board.setBoardCells();

        // Seteo el turno
        turnController.startGame();

        // Arranca el juego
        GameContainerView gameContainer = new GameContainerView();
        Scene gameScene = new Scene(gameContainer);
        stage.setScene(gameScene);
        stage.setFullScreen(true);
        stage.setTitle("AlgoChess");
        stage.show();
    }

}


