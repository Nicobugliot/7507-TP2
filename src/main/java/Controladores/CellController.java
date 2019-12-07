package Controladores;

import Modelo.Board;
import Modelo.Cell;
import Modelo.Observer;
import Modelo.Player;
import Modelo.exceptions.*;
import Modelo.unit.Battalion;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import Vista.popUp.AlertPopUpWindow;
import javafx.application.Platform;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController extends Observer implements EventHandler<MouseEvent> {

    private final Integer yPosition;
    private final Integer xPosition;
    private static Board board = Board.getBoard();
    private TurnController turnController = TurnController.getInstance();
    private GameSystemController gameSystemController = GameSystemController.getInstance();
    private CellView cellView;

    public CellController(Integer x, Integer y, CellView cellView) {
        this.xPosition = x;
        this.yPosition = y;
        this.cellView = cellView;
    }

    @Override
    public void handle(MouseEvent event) {
        Player actualPlayer = turnController.getActualPlayer();

        if (turnController.getSetUnit() != null) {
            initializeUnitController(actualPlayer);
        } else if (gameSystemController.getUnitAbility() != null) { // Caso de ataque
            attackUnitController(actualPlayer);
        } else if (gameSystemController.getUnitToMove() != null) {
            moveUnitController(actualPlayer);
        } else if (gameSystemController.getBattalionLeaderToMove() != null) {
            moveBattalionController(actualPlayer);
        } else if (gameSystemController.getBattalionLeader() != null) {
            showUnitController();
            try {
                makeBattalion(board.getCell(xPosition, yPosition).getUnit());
            } catch (BattalionException err ) {
                new AlertPopUpWindow()
                        .display("Battalion error", err.getMessage());
                actualizeView();
                gameSystemController.setBattalionLeader(null);
                gameSystemController.resetUnitBattalion();
            }

        } else if (!board.getCell(xPosition, yPosition).isEmpty()) {
            actualizeView();
            if (turnController.getFirstPlayerFinish() && turnController.getSecondPlayerFinish()) {
                try {
                    gameSystemController.setLastCellView(cellView);
                    showUnitController();
                } catch (NullPointerException err) {
                    gameSystemController.setLastCellView(cellView);
                    showUnitController();
                }
            }
        }
    }

    private void makeBattalion(Unit unit) {
        gameSystemController.addUnitBattalion(unit);
        if (gameSystemController.getUnitBattalion().size() == 2) {
            gameSystemController
                    .getBattalionLeader()
                    .formBattalion(gameSystemController.getUnitBattalion().get(0), gameSystemController.getUnitBattalion().get(1));
            gameSystemController.setBattalionLeader(null);
            gameSystemController.resetUnitBattalion();
        }
    }

    /**
     * Funcion para mostrar las estadisticas de la unidad en la vista
     */
    private void showUnitController() {
        if (board.getCell(xPosition, yPosition).getUnit().leadsABattalion()) {
            InfantrySoldier infantrySoldier = (InfantrySoldier) board.getCell(xPosition, yPosition).getUnit();
            Battalion battalion = infantrySoldier.getBattalion();
            for (Unit soldiers: battalion.getUnits()) {
                CellView cellView = gameSystemController.getCellView(soldiers.getCell().getYPosition(), soldiers.getCell().getXPosition());
                cellView.highlightUnit();
            }
        }
        cellView.highlightUnit();
        Unit cellUnit = board.getCell(xPosition, yPosition).getUnit();
        gameSystemController.refreshUnitView(cellUnit, cellView);
    }

    /**
     * Funcion que se encarga de inicializar una unidad en el tablero
     * @param actualPlayer
     */
    private void initializeUnitController(Player actualPlayer) {
        Unit unit = turnController.getSetUnit();
        try {
            unit.setTeam(actualPlayer.getTeam());
            actualPlayer.initializeUnit(unit, board.getCell(xPosition, yPosition));
            unit.attachObserver(this);
            turnController.unitHasBeenSet();
            actualizeView();
        } catch (MovementException err) {
            new AlertPopUpWindow()
                    .display("Movement Exception", err.getMessage());
        } catch (OccupiedCellException err) {
            new AlertPopUpWindow()
                    .display("Movement Exception", err.getMessage());
        }
    }

    /**
     * Funcion que se encarga de la logica para mover la unidad en el tablero
     * @param actualPlayer
     */
    private void moveUnitController(Player actualPlayer) {
        //TODO falta el manejo de excepciones
        try {
            Cell cellToMove = board.getCell(xPosition, yPosition);
            actualPlayer.moveUnit(gameSystemController.getUnitToMove(), cellToMove);
            gameSystemController.getUnitToMove().deleteObservers();

            // Le seteo los observadores
            gameSystemController.getUnitToMove().attachObserver(actualPlayer);
            gameSystemController.getUnitToMove().attachObserver(this);
            gameSystemController.getUnitToMove().attachObserver(cellToMove);

            gameSystemController.unitHasBeenMoved();
            actualizeView();
            turnController.changeTurn();
        } catch (MovementException err) {
            new AlertPopUpWindow()
                    .display("Move Exception", err.getMessage());
            gameSystemController.setUnitMoveTo(null);
        } catch (OccupiedCellException err) {
            new AlertPopUpWindow()
                    .display("Move Exception", err.getMessage());
            gameSystemController.setUnitMoveTo(null);
        }
    }

    private void moveBattalionController(Player actualPlayer) {
        //TODO falta el manejo de excepciones
        try {
            Cell cellToMove = board.getCell(xPosition, yPosition);
            actualPlayer.moveBattalion(gameSystemController.getBattalionLeaderToMove(), cellToMove);        //movimiento tablero
            gameSystemController.getBattalionLeaderToMove().deleteObservers();

            // Le seteo los observadores
            gameSystemController.getBattalionLeaderToMove().attachObserver(actualPlayer);
            gameSystemController.getBattalionLeaderToMove().attachObserver(this);
            gameSystemController.getBattalionLeaderToMove().attachObserver(cellToMove);

            gameSystemController.battalionLeaderHasBeenMoved();
            actualizeView();
            turnController.changeTurn();
        } catch (MovementException err) {
            new AlertPopUpWindow()
                    .display("Move Exception", err.getMessage());
            gameSystemController.setBattalionLeaderMoveTo(null);
        }
    }

    /**
     * Funcion que se encarga de la logica para atacar a otra unidad
     * @param actualPlayer
     */
    private void attackUnitController(Player actualPlayer) {
        //TODO falta el manejo de excepciones
        try {
            Cell cellToAttack = board.getCell(xPosition, yPosition);
            actualPlayer.useUnit(gameSystemController.getUnitAbility(), cellToAttack);
            gameSystemController.unitAbilityHasBeenUsed();
            turnController.changeTurn();
        } catch (AbilityException err) {
            new AlertPopUpWindow()
                    .display("Attack Exception", err.getMessage());
            gameSystemController.setUnitAbility(null);
        } catch (GameOverException err) {
            new AlertPopUpWindow()
                    .display("You loose", err.getMessage());
            Platform.exit();
        } catch (EmptyCellException err) {
            new AlertPopUpWindow()
                    .display("Attack Exception", err.getMessage());
            gameSystemController.setUnitAbility(null);
        }
    }

    private void actualizeView() {
        for(Integer i = 0; i < 20; i++){
            for(Integer j = 0; j < 20; j++){
                CellView cellView = gameSystemController.getCellView(i, j);
                if (board.getCell(j, i).getUnit() != null) {
                    addUnitToBoard(board.getCell(j, i).getUnit(), cellView);
                } else {
                    cellView.clearImage();
                }
            }
        }
    }

    private void addUnitToBoard(Unit unit, CellView cellView) {
        String color = unit.getTeam() == 0 ? "rojo" : "azul";
        cellView.updateImage(unit.getType().toString() + "_" + color + ".png");
    }

    @Override
    public void update(Unit unit) {
        cellView.clearImage();
    }
}