package Vista;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class MainMenu extends Application implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button settingsButton;
    private Button startGameButton;
    private Button exitButton;
    private Button menuButton;
    private Integer MAX_PLAYERS = 2;
    private Background backgroundImageObject;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoChess v1.0 - Alpha");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeConfirmation();
        });

        //file path
        String path = "/caballo_rojo.png";

        // create a image
        Image image = new Image(getClass().getResourceAsStream(path));

        // create a background image
        BackgroundImage backgroundImage = new BackgroundImage(image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);

        // create Background
        backgroundImageObject = new Background(backgroundImage);

        Scene menuScene = generateMenuScene();

        primaryStage.setScene(menuScene);
        primaryStage.show();
    }

    @Override
    public void handle(ActionEvent actionEvent) { //para que maneje algunos eventos desde esta clase, a esos objectos hay que pasarles .setOnAction(this)
        if(actionEvent.getSource() == settingsButton){
            //le hicieron clic a settingsButton
            primaryStage.setScene(generateSettingsScene());
            primaryStage.show();

        }else if(actionEvent.getSource() == startGameButton){
            //le hicieron clic a startGameButton
            //primaryStage.setScene(generatePreGameScene());
            //primaryStage.show();
            BoardView boardView = new BoardView();
            try {
                boardView.startGame();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else if(actionEvent.getSource() == exitButton ){
            //le hicieron clic a exitButton
            closeConfirmation();

        }else if(actionEvent.getSource() == menuButton){
            //le hicieron clic a exitButton
            primaryStage.setScene(generateMenuScene());
            primaryStage.show();
        }
    }

    private Scene generateMenuScene(){

        Label menuTitle = new Label("Main Menu");

        settingsButton = new Button("Settings");
        settingsButton.setOnAction(this);

        startGameButton = new Button( "Play");
        startGameButton.setOnAction(this);

        exitButton = new Button("Exit");
        exitButton.setOnAction(this);

        //Layout vertical
        VBox menuLayout = new VBox(20);
        menuLayout.getChildren().addAll(menuTitle,settingsButton,startGameButton,exitButton);
        menuLayout.setAlignment(Pos.CENTER);
        //Agregando el fondo
        menuLayout.setBackground(backgroundImageObject);

        Scene menuScene = new Scene(menuLayout, 417, 417);

        return menuScene;
    }

    private Scene generatePreGameScene(){
        String[] playerNames = new String[MAX_PLAYERS+1];
        playerNames[0] = "FILLER";
        for (Integer i = 1; i <= 2 ; i++) {
            playerNames[i] = askPLayerName(i.toString());
        }
        return generateMenuScene();
    }

    private String askPLayerName( String playerNumber){
        InputNamePopUpWindow askPlayerForName = new InputNamePopUpWindow();
        String selectedName = askPlayerForName.display(
                "Waiting for name", "Player "+playerNumber+" what's your name?",
                "Accept",
                "playerNumber");

        return selectedName;
    }

    private Scene generateSettingsScene() {
        Label settingsTitle = new Label("Settings");
        menuButton = new Button("Main Menu");
        menuButton.setOnAction(this);
        //Layout vertical
        VBox settingsLayout = new VBox(20);
        settingsLayout.getChildren().addAll(settingsTitle,menuButton);

        Scene settingsScene = new Scene(settingsLayout, 200, 200);

        return settingsScene;

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