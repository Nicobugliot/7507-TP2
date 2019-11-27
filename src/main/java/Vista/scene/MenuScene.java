package Vista.scene;


import Controladores.Botones.ExitButtonController;
import Controladores.Botones.PlayButtonController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class MenuScene extends VBox {

    private Button startGameButton;
    private Button exitButton;

    public MenuScene(Stage stage) {
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
        Background backgroundImageObject = new Background(backgroundImage);

        Label menuTitle = new Label("Main Menu");

        startGameButton = new Button("Play");
        startGameButton.setOnAction(new PlayButtonController(stage));

        exitButton = new Button("Exit");
        exitButton.setOnAction(new ExitButtonController(stage));

        /**
         * Configuraciones del VBox
         */
        this.getChildren().addAll(menuTitle,startGameButton, exitButton);
        this.setSpacing(20);
        this.setMinHeight(400);
        this.setMinWidth(400);
        this.setAlignment(Pos.CENTER);
        this.setBackground(backgroundImageObject);
    }

}

