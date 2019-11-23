package Vista;

import Controladores.NameInputEventHandler;
import Controladores.SendButtonEventHandler;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class MainMenu extends Application implements EventHandler<ActionEvent> {

    private Stage primaryStage;
    private Button settingsButton;
    private Button startGameButton;
    private Button exitButton;
    private Button menuButton;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("AlgoChess v1.0 - Alpha");
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeConfirmation();
        });

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
            primaryStage.setScene(generateGameScene());
            primaryStage.show();

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

        Scene menuScene = new Scene(menuLayout, 1000, 1000);

        return menuScene;
    }

    private Scene generateGameScene(){
        TextField playerName = new TextField();
        playerName.setPromptText("Insert Player Name");

        Button sendButton = new Button();
        sendButton.setText("Ok");

        HBox horizontalContainer = new HBox(sendButton);
        horizontalContainer.setSpacing(10);

        Label aLabel = new Label();
        aLabel.setText(playerName.getText());

        VBox mainContainer = new VBox(playerName, horizontalContainer, aLabel);
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(20));

        SendButtonEventHandler SendButtonEventHandler = new SendButtonEventHandler(playerName, aLabel);
        sendButton.setOnAction(SendButtonEventHandler);

        NameInputEventHandler NameInputEventHandler = new NameInputEventHandler(sendButton);
        playerName.setOnKeyPressed(NameInputEventHandler);

        Scene menuScene = new Scene(mainContainer, 300, 250);

        return menuScene;
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