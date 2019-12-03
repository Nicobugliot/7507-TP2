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
        String cssProp = "-fx-background-color: #ecebe9,rgba(0,0,0,0.05),linear-gradient(#dcca8a, #c7a740),linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),linear-gradient(#f6ebbe, #e6c34d);"+
                "-fx-background-insets: 0,1,2,3,0;" +
                "-fx-background-radius: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-font-size: 18px;" +
                "-fx-text-fill: #311c09;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);";

        String cssPropText = "-fx-font-size: 50px;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-color-label-visible: black;" +
                "-fx-fill: black;" +
                "-fx-text-fill: #fffce1;" +
                " -fx-font-weight: bold;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;


        Label menuTitle = new Label("ALGOCHESS");
        menuTitle.setStyle(cssPropText);

        startGameButton = new Button("PLAY");
        startGameButton.setOnAction(new PlayButtonController(stage));
        startGameButton.setStyle(cssProp);

        exitButton = new Button("EXIT");
        exitButton.setOnAction(new ExitButtonController(stage));
        exitButton.setStyle(cssProp);

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

