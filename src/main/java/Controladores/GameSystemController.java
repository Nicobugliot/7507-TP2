package Controladores;

import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import Vista.mainGame.PlayerView;
import Vista.mainGame.UnitView;

import java.util.ArrayList;

public class GameSystemController {

    private static GameSystemController gameSystemController;
    private UnitView unitView;
    private PlayerView actualPlayerView;
    private PlayerView nextPlayerView;
    private CellView lastCellView;
    private Unit unitMoveTo;
    private Unit battalionLeaderMoveTo;
    private Unit setUnitAbility;
    private Unit battalionLeader;
    private ArrayList<Unit> arrayUnit = new ArrayList<Unit>();
    private CellView[][] cellViews = new CellView[20][20];

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
    }   //setBattalionMoveTo   y   battalionMoveTo

    public Unit getUnitToMove() {
        return this.unitMoveTo;
    }           // mismo pero con batallon

    public void unitHasBeenMoved() {
        this.unitMoveTo = null;
    }       // mismo pero con batallon



    public void setBattalionLeaderMoveTo(Unit unit) {
        this.battalionLeaderMoveTo = unit;
    }

    public Unit getBattalionLeaderToMove() {
        return this.battalionLeaderMoveTo;
    }

    public void battalionLeaderHasBeenMoved() {
        this.battalionLeaderMoveTo = null;
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

    public void setBattalionLeader(Unit unit) {
        battalionLeader = unit;
    }

    public Unit getBattalionLeader() {
        return battalionLeader;
    }

    public void addUnitBattalion(Unit unit) {
        arrayUnit.add(unit);
    }

    public ArrayList<Unit> getUnitBattalion() {
        return arrayUnit;
    }

    public void setCellViews(Integer x, Integer y, CellView cellView) {
        cellViews[x][y] = cellView;
    }

    public CellView getCellView(Integer x, Integer y) {
        return cellViews[x][y];
    }
}
