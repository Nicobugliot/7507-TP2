package Vista.mainGame;

import Controladores.Botones.AbilityController;
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
        abilityButton.setOnAction(new AbilityController(unit));

        /**
         * Limpio la caja y meto todas las cosas
         */
        this.getChildren().clear();
        this.getChildren().addAll(unitType, unitLife, moveToButton, abilityButton);
    }

}
