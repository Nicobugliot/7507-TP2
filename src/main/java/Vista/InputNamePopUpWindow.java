package Vista;

import Controladores.NameInputEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
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

        messageLabel = new Label(message);
        acceptButton = new Button(acceptMessage);
        acceptButton.setOnAction(this);

        playerName = new TextField();
        playerName.setPromptText("Insert name for player " + playerNumber);
        NameInputEventHandler NameInputEventHandler = new NameInputEventHandler(acceptButton);
        playerName.setOnKeyPressed(NameInputEventHandler);

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

                this.messageLabel.setText("Debe ingresar un texto");
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


