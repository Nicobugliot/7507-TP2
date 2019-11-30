package Controladores;

import Modelo.unit.Unit;
import Vista.mainGame.PlayerView;
import Vista.mainGame.UnitView;

public class GameSystemController {

    private static GameSystemController gameSystemController;
    private UnitView unitView;
    private PlayerView actualPlayerView;
    private PlayerView nextPlayerView;

    public static GameSystemController getInstance(){
        if (gameSystemController == null){
            gameSystemController = new GameSystemController();
        }
        return gameSystemController;
    }

    public void setUnitView(UnitView unitView) {
        this.unitView = unitView;
    }

    public void refreshUnitView(Unit unit) {
        unitView.setUnitStats(unit);
    }

    public void setPlayerViews(PlayerView firstPlayerView, PlayerView secondPlayerView) {
        actualPlayerView = firstPlayerView;
        actualPlayerView.turnView();
        nextPlayerView = secondPlayerView;
        nextPlayerView.notTurnView();
    }

    public void changeTurn() {
        PlayerView swapView = actualPlayerView;
        actualPlayerView = nextPlayerView;
        nextPlayerView = swapView;

        actualPlayerView.turnView();
        nextPlayerView.notTurnView();
    }

    public void refreshPlayerView() {
        actualPlayerView.refreshPoints();
    }
}
