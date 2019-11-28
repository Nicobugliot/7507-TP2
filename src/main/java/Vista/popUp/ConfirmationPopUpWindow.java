package Vista.popUp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmationPopUpWindow implements EventHandler<ActionEvent> {

    private static Button yesButton;
    private static Button noButton;
    private static Stage window;
    private static Boolean answer;

    public boolean display(String title, String message, String yesMessage, String noMessage) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(500);

        Label messageLabel = new Label(message);
        yesButton = new Button(yesMessage);
        yesButton.setOnAction(this);

        noButton = new Button(noMessage);
        noButton.setOnAction(this);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(messageLabel,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();//Espera a que cierren el popUp para dejarte interactuar con los otros escenarios

        return answer;
    }

    @Override
    public void handle(ActionEvent actionEvent) { //para que maneje algunos eventos desde esta clase, a esos objectos hay que pasarles .setOnAction(this)
        if(actionEvent.getSource() == yesButton) {
            //le hicieron clic a yesButton
            answer = true;
            window.close();
        }else if(actionEvent.getSource() == noButton) {
            //le hicieron clic a yesButton
            answer = false;
            window.close();
        }
    }
}


