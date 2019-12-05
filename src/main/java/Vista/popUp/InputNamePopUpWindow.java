package Vista.popUp;

import Controladores.NameInputEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputNamePopUpWindow implements EventHandler<ActionEvent> {

    private static Button acceptButton;
    private static Stage window;
    private static String answer;
    private Label messageLabel;
    private TextField playerName;

    public String display(String title, String message, String acceptMessage, String playerNumber) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(300);
        window.setMinHeight(250);
        String cssProp ="-fx-font-size: 18px;" +
                "-fx-background-color: linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%);"+
                "-fx-background-insets: 0,1,2,3,0;" +
                "-fx-background-radius: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-text-fill: #311c09;";

        String cssPropText = "-fx-font-size: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-color-label-visible: #ffe8a7;" +
                "-fx-fill: black;" +
                "-fx-text-fill: #000000;" +
                " -fx-font-weight: bold;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;

        messageLabel = new Label(message);
        messageLabel.setStyle(cssPropText);

        acceptButton = new Button(acceptMessage);
        acceptButton.setOnAction(this);
        acceptButton.setStyle(cssProp);

        playerName = new TextField();
        playerName.setPromptText("Insert name for player " + playerNumber+1);
        playerName.setStyle(cssPropText);

        NameInputEventHandler NameInputEventHandler = new NameInputEventHandler(acceptButton);
        playerName.setOnKeyPressed(NameInputEventHandler);
        playerName.setStyle(cssPropText);



        // create a image


        VBox layout = new VBox(10);

        layout.getChildren().addAll(messageLabel, playerName, acceptButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();//Espera a que cierren el popUp para dejarte interactuar con los otros escenarios

        return answer;
    }

    @Override
    public void handle(ActionEvent actionEvent) { //para que maneje algunos eventos desde esta clase, a esos objectos hay que pasarles .setOnAction(this)
        if(actionEvent.getSource() == acceptButton ) {
            if (this.playerName.getText().trim().equals("")) {

                this.messageLabel.setText("You must enter a name");
                this.messageLabel.setTextFill(Color.web("#FF0000"));

            } else {
                this.messageLabel.setText(this.playerName.getText());
                this.messageLabel.setTextFill(Color.web("#336600"));
                answer = this.playerName.getText();
                window.close();
            }
        }
    }
}


