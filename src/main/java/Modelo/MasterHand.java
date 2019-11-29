package Modelo;

import Modelo.exceptions.MovementException;
import Modelo.unit.Unit;
import Modelo.utils.UtilMovement;

public class MasterHand {

    public void moveUnit(Unit unit, Cell nextCell) {
        if (UtilMovement.unitCanMove(unit.getCell(), nextCell)){
            try {
                nextCell.setUnit(unit);
                unit.getCell().deleteUnit();
            } catch (MovementException err) {
                //TODO Se tiene que mostrar un mensaje de error en la pantalla del usuario.
            }
        } else {
            throw new MovementException("No puedo moverme hasta ahi");
        }
    }

    public void initializeUnit(Integer team, Unit unit, Cell cell) {
        cell.initializeUnit(team, unit);
    }

}
