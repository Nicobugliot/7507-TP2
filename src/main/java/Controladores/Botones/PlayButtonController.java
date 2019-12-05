package Controladores.Botones;


import Controladores.TurnController;
import Modelo.Board;
import Vista.mainGame.GameContainerView;
import Vista.scene.PreGameScene;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.File;
import java.nio.file.Paths;

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

        //Starting Gong
        String gongPath = "sounds/gong.mp3";
        Media gongMedia = new Media(getClass().getClassLoader().getResource(gongPath).toExternalForm());
        AudioClip gongPlayer = new AudioClip(gongMedia.getSource());
        gongPlayer.play(0.3);

        //Music
        String musicPath = "sounds/definitelyNotTheAOEMusic.mp3";
        Media media = new Media(getClass().getClassLoader().getResource(musicPath).toExternalForm());
        AudioClip musicPlayer = new AudioClip(media.getSource());
        musicPlayer.setCycleCount(AudioClip.INDEFINITE);
        musicPlayer.play(0.1);

        // Arranca el juego
        GameContainerView gameContainer = new GameContainerView();
        Scene gameScene = new Scene(gameContainer);
        stage.setTitle("AlgoChess");
        stage.setScene(gameScene);
        stage.setMaximized(true);
        stage.show();
    }


}


