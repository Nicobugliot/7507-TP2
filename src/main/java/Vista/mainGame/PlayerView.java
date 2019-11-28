package Vista.mainGame;

import Controladores.Botones.AddUnitController;
import Controladores.TurnController;
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
    private final Integer points;
    private static TurnController turnController = TurnController.getInstance();

    public PlayerView(String name, Color color, Integer points) {
        //super();
        this.name = name;
        this.color = color;
        this.points = points;

        /**
         * Configuración del texto
         * */
        Text playerText = new Text();
        playerText.setText("Player = ");
        playerText.setFont(new Font(20));
        playerText.setTextAlignment(TextAlignment.LEFT);

        Text nameText = new Text();
        nameText.setText(this.name);
        nameText.setFont(new Font(20));

        Text pointText = new Text();
        pointText.setText("Points = ");
        pointText.setFont(new Font(20));
        pointText.setTextAlignment(TextAlignment.LEFT);

        Text pointsText = new Text(Integer.toString(this.points));
        pointsText.setFont(new Font(20));
        pointsText.setTextAlignment(TextAlignment.LEFT);

        Text spaceText = new Text();
        spaceText.setText(" ");
        spaceText.setFont(new Font(20));
        spaceText.setTextAlignment(TextAlignment.LEFT);

        /**
         * Configuración de los botones
         * */
        Button addUnitButton = new Button("Add unit");
        addUnitButton.setAlignment(Pos.CENTER);

        Button changeTurn = new Button("Finish turn");
        changeTurn.setAlignment(Pos.CENTER_RIGHT);


        Button soldierBuyButton = new Button("Soldier");
        soldierBuyButton.setAlignment(Pos.CENTER_RIGHT);

        Button riderButton = new Button("Rider");
        riderButton.setAlignment(Pos.CENTER_RIGHT);

        Button healerButton = new Button("Healer");
        changeTurn.setAlignment(Pos.CENTER_RIGHT);

        Button catapultButton = new Button("Catapult");
        changeTurn.setAlignment(Pos.CENTER_RIGHT);

        /**
         * Asigno controladores para los botones
         */
        addUnitButton.setOnAction(new AddUnitController("Add"));
        changeTurn.setOnAction(turnController);
        soldierBuyButton.setOnAction(new AddUnitController("Soldier"));
        riderButton.setOnAction(new AddUnitController("Rider"));
        healerButton.setOnAction(new AddUnitController("Healer"));
        catapultButton.setOnAction(new AddUnitController("Catapult"));

        /**
         * Configuración del container
         * */
        this.setMaxWidth(500);
        this.setMaxHeight(50);
        this.setBackground(
                new Background(new BackgroundFill(color,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));

        this.getChildren().addAll(playerText,
                nameText,
                spaceText,
                pointText,
                pointsText,
                addUnitButton,
                changeTurn,
                soldierBuyButton,
                riderButton,
                healerButton,
                catapultButton);
    }


}
