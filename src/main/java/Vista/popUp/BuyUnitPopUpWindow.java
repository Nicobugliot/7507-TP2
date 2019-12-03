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

public class BuyUnitPopUpWindow implements EventHandler<ActionEvent> {

    private static Button yesButton;
    private static Button noButton;
    private static Stage window;
    private static Boolean answer;
    private static String title = "Unit Overview";

    public boolean display(String hp, String cost, String abilityDescription, String behaviour) {
        window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(500);
        window.setMinHeight(500);

        Label hpLabel = new Label(hp);
        Label costLabel = new Label(cost);
        Label abilityDescriptionLabel = new Label(abilityDescription);
        Label behaviourLabel = new Label(behaviour);

        yesButton = new Button("Buy");
        yesButton.setOnAction(this);

        noButton = new Button("Back");
        noButton.setOnAction(this);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(hpLabel,costLabel,abilityDescriptionLabel,behaviourLabel,yesButton,noButton);
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


