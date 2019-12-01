package Controladores;

import Modelo.Board;
import Modelo.Cell;
import Modelo.Observer;
import Modelo.Player;
import Modelo.exceptions.*;
import Modelo.unit.Unit;
import Vista.mainGame.CellView;
import Vista.popUp.AlertPopUpWindow;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController extends Observer implements EventHandler<MouseEvent> {

    private final Integer yPosition;
    private final Integer xPosition;
    private static Board board = Board.getBoard();
    private TurnController turnController = TurnController.getInstance();
    private GameSystemController gameSystemController = GameSystemController.getInstance();
    private CellView cellView;
    private CellView lastCellView;

    public CellController(Integer x, Integer y, CellView cellView) {
        this.xPosition = x;
        this.yPosition = y;
        this.cellView = cellView;
    }

    private void addUnitToBoard(String unitName) {
        Player actualPlayer = turnController.getActualPlayer();
        String color = actualPlayer.getTeam() == 0  ? "rojo" : "azul";
        cellView.updateImage(unitName + "_" + color + ".png");
        turnController.unitHasBeenSet();
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
        } else if (!board.getCell(xPosition, yPosition).isEmpty()) { //
            showUnitController();
        } else {
            System.out.println(xPosition + " " + yPosition);
        }
    }

    /**
     * Funcion para mostrar las estadisticas de la unidad en la vista
     */
    private void showUnitController() {
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
            addUnitToBoard(unit.getType().toString());
            unit.attachObserver(this);
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
            addUnitToBoard(gameSystemController.getUnitToMove().getType().toString());
            gameSystemController.getUnitToMove().deleteObservers();

            // Le seteo los observadores
            gameSystemController.getUnitToMove().attachObserver(actualPlayer);
            gameSystemController.getUnitToMove().attachObserver(this);
            gameSystemController.getUnitToMove().attachObserver(cellToMove);

            gameSystemController.unitHasBeenMoved(cellView);
            turnController.changeTurn();
        } catch (MovementException err) {
            new AlertPopUpWindow()
                    .display("Move Exception", err.getMessage());
            gameSystemController.setUnitMoveTo(null);
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
        } catch (EmptyCellException err) {
            new AlertPopUpWindow()
                    .display("Attack Exception", err.getMessage());
            gameSystemController.setUnitAbility(null);
        }
    }

    @Override
    public void update(Unit unit) {
        System.out.println(unit.getType());
        cellView.clearImage();
    }
}