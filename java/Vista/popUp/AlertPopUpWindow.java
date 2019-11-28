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
        this.window = new Stage();

        this.window.initModality(Modality.APPLICATION_MODAL);
        this.window.setTitle(title);
        this.window.setMinWidth(250);

        Label messageLabel = new Label(message);
        this.closeButton = new Button("Close");
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


