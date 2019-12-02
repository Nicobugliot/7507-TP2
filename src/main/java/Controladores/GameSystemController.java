package Controladores;

import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import Vista.mainGame.PlayerView;
import Vista.mainGame.UnitView;

public class GameSystemController {

    private static GameSystemController gameSystemController;
    private UnitView unitView;
    private PlayerView actualPlayerView;
    private PlayerView nextPlayerView;
    private CellView lastCellView;
    private Unit unitMoveTo;
    private Unit setUnitAbility;

    public static GameSystemController getInstance(){
        if (gameSystemController == null){
            gameSystemController = new GameSystemController();
        }
        return gameSystemController;
    }

    public void setUnitView(UnitView unitView) {
        this.unitView = unitView;
    }

    public void refreshUnitView(Unit unit, CellView cellView) {
        unitView.setUnitStats(unit, cellView);
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

        unitView.clearView();
    }

    public void refreshPlayerView() {
        actualPlayerView.refreshPoints();
    }

    public void setUnitMoveTo(Unit unit) {
        this.unitMoveTo = unit;
    }

    public Unit getUnitToMove() {
        return this.unitMoveTo;
    }

    public void unitHasBeenMoved(CellView cellView) {
        this.unitMoveTo = null;
        lastCellView.clearImage();
    }

    public void setLastCellView(CellView cellView) {
        this.lastCellView = cellView;
    }

    public CellView getLastCellView() {
        return this.lastCellView;
    }

    public void setUnitAbility(Unit unit) {
        this.setUnitAbility = unit;
    }

    public Unit getUnitAbility() {
        return this.setUnitAbility;
    }

    public void unitAbilityHasBeenUsed() {
        this.setUnitAbility = null;
    }
}
