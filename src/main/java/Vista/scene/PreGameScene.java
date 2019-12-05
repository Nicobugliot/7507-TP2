package Vista.scene;

import Controladores.TurnController;
import Modelo.Player;
import Vista.popUp.InputNamePopUpWindow;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class PreGameScene extends VBox {

    private ArrayList<Player> players = new ArrayList<>();
    private static TurnController turnController = TurnController.getInstance();

    public PreGameScene() {
        super();
    }

    public void start() {
        //ArrayList<Player> playerNames = new ArrayList<>();
        for (Integer i = 0; i < 2 ; i++) {
            Player player = new Player(askPlayerName(i.toString()));
            // Agrego la clase jugador a la lista
            players.add(player);
            player.setTeam(i);
        }

        // Le doy los players a TurnController
        turnController.setPlayers(players);
    }

    private String askPlayerName( String playerNumber){
        InputNamePopUpWindow askPlayerForName = new InputNamePopUpWindow();
        String playerNumberStr;
        if(playerNumber.equals("0")){playerNumberStr ="1";}
        else{playerNumberStr ="2";}

        String selectedName = askPlayerForName.display(
                "Waiting for name", "Player "+playerNumberStr+" what's your name?",
                "Accept", "playerNumberStr");

        return selectedName;
    }
}
