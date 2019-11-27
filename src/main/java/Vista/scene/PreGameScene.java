package Vista.scene;

import Controladores.TurnController;
import Modelo.Player;
import Vista.popUp.InputNamePopUpWindow;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreGameScene extends VBox {

    private ArrayList<Player> players = new ArrayList<>();

    public PreGameScene() {
        super();
    }

    public void start() {
        //ArrayList<Player> playerNames = new ArrayList<>();
        for (Integer i = 0; i < 2 ; i++) {
            Player player = new Player(askPlayerName(i.toString()));
            // Agrego la clase jugador a la lista
            players.add(player);

            // Para debugger
            System.out.println(player.getName());
        }

        // Le doy los players a TurnController
        TurnController.getInstance().setPlayers(players);
    }

    private String askPlayerName( String playerNumber){
        InputNamePopUpWindow askPlayerForName = new InputNamePopUpWindow();
        String selectedName = askPlayerForName.display(
                "Waiting for name", "Player "+playerNumber+" what's your name?",
                "Accept",
                "playerNumber");

        return selectedName;
    }
}
