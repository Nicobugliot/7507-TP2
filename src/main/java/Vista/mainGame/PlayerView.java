package Vista.mainGame;

import Controladores.Botones.AddUnitController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PlayerView extends HBox {

    private final String name;
    private final Color color;

    public PlayerView(String name, Color color) {
        //super();
        this.name = name;
        this.color = color;

        /**
         * Configuración del texto
         * */
        Text nameText = new Text();
        nameText.setText(this.name);
        nameText.setFont(new Font(20));
        nameText.setTextAlignment(TextAlignment.LEFT);

        /**
         * Configuración de los botones
         * */
        Button addUnitButton = new Button();
        addUnitButton.setText("Add Unit");
        addUnitButton.setAlignment(Pos.CENTER);

        // Le indico qué controlador tiene asignado
        addUnitButton.setOnAction(new AddUnitController());


        /**
         * Configuración del container
         * */
        this.setMaxWidth(500);
        this.setMaxHeight(50);
        this.setBackground(
                new Background(new BackgroundFill(color,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        this.getChildren().addAll(nameText, addUnitButton);
    }


}
