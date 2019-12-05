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
                "-fx-color-label-visible: #ffe8a7;" +
                "-fx-fill: black;" +
                "-fx-text-fill: #000000;" +
                " -fx-font-weight: bold;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;

        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(500);

        Label messageLabel = new Label(message);
        messageLabel.setStyle(cssPropText);
        yesButton = new Button(yesMessage);
        yesButton.setOnAction(this);
        yesButton.setStyle(cssProp);
        noButton = new Button(noMessage);
        noButton.setOnAction(this);
        noButton.setStyle(cssProp);

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


