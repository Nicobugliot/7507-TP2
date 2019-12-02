package Vista;

import Modelo.Player;
import Vista.popUp.ConfirmationPopUpWindow;
import Vista.scene.MenuScene;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.util.ArrayList;


public class MainMenu extends Application{

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoChess v1.3 - Alpha");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeConfirmation();
        });

        // Se inicia el menu principal
        Scene menuScene = new Scene(new MenuScene(primaryStage));
        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    private void closeConfirmation(){
        ConfirmationPopUpWindow confirmExit = new ConfirmationPopUpWindow();
        boolean wantedToCLose = confirmExit.display(
                "Exit", "Are you sure you want to exit the game?",
                "I can't take it anymore, the game is too hard",
                "I want to keep playing");
        if (wantedToCLose) primaryStage.close();
    }
}