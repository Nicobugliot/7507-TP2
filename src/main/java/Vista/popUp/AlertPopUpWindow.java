package Vista.popUp;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.geometry.*;

public class AlertPopUpWindow implements EventHandler<ActionEvent> {

    private Button closeButton;
    private Stage window;

    public void display(String title, String message) {
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

        this.window = new Stage();

        this.window.initModality(Modality.APPLICATION_MODAL);
        this.window.setTitle(title);
        this.window.setMinWidth(250);

        Label messageLabel = new Label(message);
        messageLabel.setStyle(cssPropText);
        this.closeButton = new Button("Close");
        closeButton.setStyle(cssProp);
        this.closeButton.setOnAction(this);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(messageLabel,this.closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        this.window.setScene(scene);
        this.window.showAndWait();//Espera a que cierren el popUp para dejarte interactuar con los otros escenarios
    }

    @Override
    public void handle(ActionEvent actionEvent) { //para que maneje algunos eventos desde esta clase, a esos objectos hay que pasarles .setOnAction(this)
        if(actionEvent.getSource() == closeButton) {
            //le hicieron clic a closeButton
            this.window.close();
        }
    }
}


