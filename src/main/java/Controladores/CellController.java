package Controladores;

import Modelo.Board;
import Modelo.Cell;
import Modelo.Player;
import Modelo.exceptions.MovementException;
import Modelo.exceptions.OccupiedCellException;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit;
import Modelo.unit.UnitType;
import Vista.mainGame.CellView;
import Vista.mainGame.UnitView;
import javafx.event.*;
import javafx.scene.input.MouseEvent;

public class CellController implements EventHandler<MouseEvent> {

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
            Unit unit = turnController.getSetUnit();
            try {
                unit.setTeam(actualPlayer.getTeam());
                actualPlayer.initializeUnit(unit, board.getCell(xPosition, yPosition));
                addUnitToBoard(unit.getType().toString());
            } catch (MovementException err) {
                System.out.println("No se puede iniciar una unidad en celda enemiga");
            } catch (OccupiedCellException err) {
                System.out.println("No se puede iniciar una unidad en una celda ocupada");
            }
        } else if (!board.getCell(xPosition, yPosition).isEmpty()) { //
            Unit cellUnit = board.getCell(xPosition, yPosition).getUnit();

            /**
             * Seteo la celda y la unidad para ver que es lo que quiere hacer el jugador
             */
            gameSystemController.refreshUnitView(cellUnit, cellView);

        } else if (turnController.getUnitAbility() != null) { // Caso de ataque
            Cell cellToAttack = board.getCell(xPosition, yPosition);
            actualPlayer.useUnit(turnController.getUnitAbility(), cellToAttack);

        } else if (gameSystemController.getUnitToMove() != null) {
            Cell cellToMove = board.getCell(xPosition, yPosition);
            actualPlayer.moveUnit(gameSystemController.getUnitToMove(), cellToMove);
            addUnitToBoard(gameSystemController.getUnitToMove().getType().toString());
            gameSystemController.unitHasBennMoved();
        } else {
            System.out.println(xPosition + " " + yPosition);
        }
    }
}
