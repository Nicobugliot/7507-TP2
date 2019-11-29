package Vista.mainGame;

import Controladores.Botones.AddUnitController;
import Controladores.TurnController;
import Modelo.Player;
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

    private final Player player;
    private final Color color;
    private static TurnController turnController = TurnController.getInstance();
    private Text playerText;
    private Text nameText;
    private Text spaceText;
    private Text pointText;
    private Text pointsText;
    private Button addUnitButton;
    private Button changeTurnButton;
    private Button soldierButton;
    private Button riderButton;
    private Button healerButton;
    private Button catapultButton;

    public PlayerView(Player player, Color color) {
        //super();
        this.player = player;
        this.color = color;

        /**
         * Configuración del texto
         * */
        playerText = new Text();
        playerText.setText("Player = ");
        playerText.setFont(new Font(20));
        playerText.setTextAlignment(TextAlignment.LEFT);

        nameText = new Text();
        nameText.setText(player.getName());
        nameText.setFont(new Font(20));

        pointText = new Text();
        pointText.setText("Points = ");
        pointText.setFont(new Font(20));
        pointText.setTextAlignment(TextAlignment.LEFT);

        pointsText = new Text();
        pointsText.setText(Integer.toString(player.getPoints()));
        pointsText.setFont(new Font(20));
        pointsText.setTextAlignment(TextAlignment.LEFT);

        spaceText = new Text();
        spaceText.setText(" ");
        spaceText.setFont(new Font(20));
        spaceText.setTextAlignment(TextAlignment.LEFT);

        /**
         * Configuración de los botones
         * */
        addUnitButton = new Button("Add unit");
        addUnitButton.setAlignment(Pos.CENTER);

        changeTurnButton = new Button("Finish turn");
        changeTurnButton.setAlignment(Pos.CENTER_RIGHT);

        soldierButton = new Button("Soldier");
        soldierButton.setAlignment(Pos.CENTER_RIGHT);

        riderButton = new Button("Rider");
        riderButton.setAlignment(Pos.CENTER_RIGHT);

        healerButton = new Button("Healer");
        healerButton.setAlignment(Pos.CENTER_RIGHT);

        catapultButton = new Button("Catapult");
        catapultButton.setAlignment(Pos.CENTER_RIGHT);

        /**
         * Asigno controladores para los botones
         */
        addUnitButton.setOnAction(new AddUnitController("Add"));
        changeTurnButton.setOnAction(turnController);
        soldierButton.setOnAction(new AddUnitController("Soldier"));
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
                changeTurnButton,
                soldierButton,
                riderButton,
                healerButton,
                catapultButton);
    }

    public void refreshPoints() {
        int index = this.getChildren().indexOf(pointsText);

        Text newPointsText = new Text();
        newPointsText.setText(Integer.toString(player.getPoints()));
        newPointsText.setFont(new Font(20));
        newPointsText.setTextAlignment(TextAlignment.LEFT);
        pointsText = newPointsText;

        this.getChildren().set(index, pointsText);
    }

    public void turnView() {
        this.getChildren().clear();

        this.getChildren().addAll(playerText,
                nameText,
                spaceText,
                pointText,
                pointsText,
                addUnitButton,
                changeTurnButton,
                soldierButton,
                riderButton,
                healerButton,
                catapultButton);
    }

    public void notTurnView() {
        this.getChildren().clear();

        this.getChildren().addAll(playerText,
                nameText,
                spaceText,
                pointText,
                pointsText);
    }

}
