package Vista.mainGame;

import Controladores.Botones.AbilityController;
import Controladores.Botones.BattalionController;
import Controladores.Botones.MoveButtonController;
import Modelo.unit.Unit;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

public class UnitView extends HBox {

    private final static double WIDTH = 300;
    private final static double HEIGHT = 1000;


    public UnitView() {
        this.setMaxWidth(WIDTH);
        this.setMaxHeight(HEIGHT);
        this.setStyle("-fx-background-color: grey");
    }

    public void setUnitStats(Unit unit, CellView cellView) {
        String cssProp = "-fx-background-color:#eee0c6;"+
                "-fx-background-insets: 0,1,2,3,0;" +
                "-fx-background-radius: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-font-size: 9px;" +
                "-fx-text-fill: #000000;" +
                " -fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);";


        //TODO sacar el harcode a todo.
        Text unitType = new Text("Unidad");
        Text unitLife = new Text(unit.getLife().toString());

        /**
         * Seteo los botones
         */
        Button moveToButton = new Button("Move unit");
        Button abilityButton = new Button("Atack");

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
        this.getChildren().addAll(unitType, unitLife, moveToButton, abilityButton);
        this.setSpacing(20);
        this.setMinHeight(400);
        this.setMinWidth(400);

        // En el caso del soldado para el batallón
        if (unit.canFormBattalions()) {
            Button battalionButton = new Button("Make battalion");
            battalionButton.setOnAction(new BattalionController(unit));
            battalionButton.setStyle(cssProp);
            this.getChildren().add(battalionButton);
        }
    }

    public void clearView() {
        this.getChildren().clear();
    }

}
