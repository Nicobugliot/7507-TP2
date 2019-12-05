package Vista.mainGame;

import Controladores.Botones.AbilityController;
import Controladores.Botones.BattalionController;
import Controladores.Botones.MoveBattalionButtonController;
import Controladores.Botones.MoveButtonController;
import Modelo.unit.Unit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class UnitView extends VBox {

    private final static double WIDTH = 100;
    private final static double HEIGHT = 1000;


    public UnitView() {
        this.setMaxWidth(WIDTH);
        this.setMaxHeight(HEIGHT);
        this.setStyle("-fx-background-color: grey");
    }

    public void setUnitStats(Unit unit, CellView cellView) {
        String cssProp = "-fx-background-color: #ecebe9,rgba(0,0,0,0.05),linear-gradient(#dcca8a, #c7a740),linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%),linear-gradient(#f6ebbe, #e6c34d);"+
                "-fx-background-insets: 0,1,2,3,0;" +
                "-fx-background-radius: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-font-size: 15px;" +
                "-fx-text-fill: #311c09;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);";
        String cssPropText = "-fx-font-size: 50px;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-color-label-visible: #ffe8a7;" +
                "-fx-fill: black;" +
                "-fx-text-fill: #000000;" +
                " -fx-font-weight: bold;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;


        //TODO sacar el harcode a todo.
        Text unitLife = new Text("HP: " + unit.getLife().toString());
        unitLife.setStyle(cssPropText);
        /**
         * Seteo los botones
         */
        Button moveToButton = new Button("Move unit");
        moveToButton.setStyle(cssProp);
        Button abilityButton = new Button("Attack");
        abilityButton.setStyle(cssProp);

        /**
         * Controladores para los botones
         */
        moveToButton.setOnAction(new MoveButtonController(unit, cellView));
        moveToButton.setStyle(cssProp);
        abilityButton.setOnAction(new AbilityController(unit));
        abilityButton.setStyle(cssProp);

        /**
         * Limpio la caja y meto todas las cosas
         */
        this.getChildren().clear();
        this.getChildren().addAll(unitLife, moveToButton, abilityButton);
        this.setSpacing(20);
        this.setMinHeight(200);
        this.setMinWidth(200);

        // En el caso del soldado para el batallón
        if (unit.canFormBattalions()) {
            Button battalionButton = new Button("Make battalion");
            battalionButton.setOnAction(new BattalionController(unit));
            battalionButton.setStyle(cssProp);                                  // crear boton para moverse en batallon

            Button moveBattalionButton = new Button("Move battalion");
            moveBattalionButton.setOnAction(new MoveBattalionButtonController(unit, cellView));
            moveBattalionButton.setStyle(cssProp);

            this.getChildren().addAll(battalionButton, moveBattalionButton);
        }
    }

    public void clearView() {
        this.getChildren().clear();
    }

}
