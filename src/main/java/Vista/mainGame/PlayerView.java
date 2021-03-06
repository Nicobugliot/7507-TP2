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
    private Button changeTurnButton;
    private Button soldierButton;
    private Button riderButton;
    private Button healerButton;
    private Button catapultButton;
    private String cssPropText;

    public PlayerView(Player player, Color color) {
        this.player = player;
        this.color = color;
        String cssProperties ="fx-font-size: 18px;" +
                "-fx-background-color: linear-gradient(#f9f2d6 0%, #f4e5bc 20%, #e6c75d 80%, #e2c045 100%);"+
                "-fx-background-insets: 0,1,2,3,0;" +
                "-fx-background-radius: 50;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-padding: 15 30 15 30;" +
                "-fx-text-fill: #311c09;";

         this.cssPropText = "-fx-font-size: 30;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-color-label-visible: #ffe8a7;" +
                "-fx-fill: #ffe8a7;" +
                "-fx-text-fill: bold;" +
                "-fx-font-weight: bold;" +
                "-fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;


        /**
         * Configuración del texto
         * */

        nameText = new Text();
        nameText.setText(player.getName());
        nameText.setStyle(cssPropText);

        pointText = new Text();
        pointText.setText(" = ");
        pointText.setStyle(cssPropText);
        pointText.setTextAlignment(TextAlignment.LEFT);

        pointsText = new Text();
        pointsText.setText(Integer.toString(player.getPoints()));
        pointsText.setStyle(cssPropText);
        pointsText.setTextAlignment(TextAlignment.LEFT);

        spaceText = new Text();
        spaceText.setText(" ");
        spaceText.setStyle(cssPropText);
        spaceText.setTextAlignment(TextAlignment.LEFT);

        /**
         * Configuración de los botones y sus estilos
         * */


        changeTurnButton = new Button("Finish turn");
        changeTurnButton.setAlignment(Pos.CENTER_RIGHT);
        changeTurnButton.setStyle(cssProperties);

        soldierButton = new Button("Soldier");
        soldierButton.setAlignment(Pos.CENTER_RIGHT);
        soldierButton.setStyle(cssProperties);

        riderButton = new Button("Rider");
        riderButton.setAlignment(Pos.CENTER_RIGHT);
        riderButton.setStyle(cssProperties);

        healerButton = new Button("Healer");
        healerButton.setAlignment(Pos.CENTER_RIGHT);
        healerButton.setStyle(cssProperties);

        catapultButton = new Button("Catapult");
        catapultButton.setAlignment(Pos.CENTER_RIGHT);
        catapultButton.setStyle(cssProperties);

        /**
         * Asigno controladores para los botones
         */
        changeTurnButton.setOnAction(turnController);
        soldierButton.setOnAction(new AddUnitController("Soldier"));
        riderButton.setOnAction(new AddUnitController("Rider"));
        healerButton.setOnAction(new AddUnitController("Healer"));
        catapultButton.setOnAction(new AddUnitController("Catapult"));

        /**
         * Configuración del container
         * */
        this.setMaxWidth(1000);
        this.setMaxHeight(50);
        this.setBackground(
                new Background(new BackgroundFill(color,
                                CornerRadii.EMPTY,
                                Insets.EMPTY)));
        this.setSpacing(5);

        this.getChildren().addAll(nameText,
                spaceText,
                pointText,
                pointsText,
                changeTurnButton,
                soldierButton,
                riderButton,
                healerButton,
                catapultButton);
    }

    public void refreshPoints() {
        String cssPropText = "-fx-font-size: 30;" +
                "-fx-font-family: 'Chalkduster';" +
                "-fx-color-label-visible: #ffe8a7;" +
                "-fx-fill: #ffe8a7;" +
                "-fx-text-fill: bold;" +
                "-fx-font-weight: bold;" +
                "-fx-effect: dropshadow( one-pass-box ,black  , 0, 0.0 , 0 , 1);" ;
        int index = this.getChildren().indexOf(pointsText);

        Text newPointsText = new Text();
        newPointsText.setText(Integer.toString(player.getPoints()));
        newPointsText.setFont(new Font(20));
        newPointsText.setTextAlignment(TextAlignment.LEFT);
        pointsText = newPointsText;
        pointsText.setStyle(cssPropText);

        this.getChildren().set(index, pointsText);
    }

    public void turnView() {

        this.getChildren().clear();

        if (turnController.getFirstPlayerFinish() && turnController.getSecondPlayerFinish()) {
            spaceText = new Text(" ");
            Text turnText = new Text("is your turn");
            spaceText.setStyle(cssPropText);
            turnText.setStyle(cssPropText);
            this.getChildren().addAll(nameText, spaceText, turnText);

        } else {
            this.getChildren().addAll(nameText,
                    spaceText,
                    pointText,
                    pointsText,
                    changeTurnButton,
                    soldierButton,
                    riderButton,
                    healerButton,
                    catapultButton);
        }

    }

    public void notTurnView() {
        this.getChildren().clear();

        if (turnController.getFirstPlayerFinish() && turnController.getSecondPlayerFinish()) {
            this.getChildren().addAll(nameText);
        } else {
            this.getChildren().addAll(nameText,
                    spaceText,
                    pointText,
                    pointsText);
        }
    }

}
