package Vista;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;

public class MainContainerView extends VBox{

    public MainContainerView(String[] players) {
        super();
        this.setAlignment(Pos.CENTER);
        this.setMaxHeight(700);
        this.setMaxWidth(500);

        PlayerView firstPlayerView = new PlayerView(players[0]);
        PlayerView secondPlayerView = new PlayerView(players[1]);
        BoardView boardView = new BoardView();

        Label title = new Label("AlgoChess");
        title.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        title.setTextAlignment(TextAlignment.CENTER);
        title.setTextFill(Color.web("000000"));

        this.getChildren().addAll(firstPlayerView, boardView.setBoardView(), secondPlayerView);
    }
}
