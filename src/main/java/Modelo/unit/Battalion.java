package Modelo.unit;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import Modelo.exceptions.BattalionException;
import Modelo.exceptions.MovementException;
import Modelo.exceptions.OccupiedCellException;
import Modelo.utils.UtilBoard;

import java.util.ArrayList;
import java.util.List;

public class Battalion extends Unit {

    private List<Unit> units;
    private UtilBoard utilBoard = new UtilBoard();

    public Battalion(){
        super(UnitType.INFANTRY);
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit){
        if (units.size() == 3) {
            throw new BattalionException("Ya son 3");
        }
        units.add(unit);
    }

    public void removeUnit(Unit unit) throws BattalionException {
        units.remove(unit);
        if (units.size() < 3){
            for (Unit battalionSoldier : units){
                this.removeUnit(battalionSoldier);
            }
            throw new BattalionException("El batallón se ha desarmado");
        }
    }

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        throw new AbilityException("Los batallones no tienen habilidad");
    }


    public void moveTo(Cell nextCellA , Cell nextCellB , Cell nextCellC) {
        List<Cell> listCell = List.of(nextCellA, nextCellB, nextCellC);
        for (Integer i = 0; i < listCell.size(); i++) {
            try {
                units.get(i).moveTo(listCell.get(i));
            } catch (OccupiedCellException err) {
                // Agarro el error de movimiento ya que se debe quedar en su lugar
            }
        }
        this.checkBattalionStatus();
    }

    private void checkBattalionStatus() {
        if(!(utilBoard.distanceBetweenCells(units.get(0).getCell() , units.get(1).getCell()) == 1 && utilBoard.distanceBetweenCells(units.get(0).getCell() , units.get(2).getCell()) == 1)
        || !(utilBoard.distanceBetweenCells(units.get(1).getCell() , units.get(0).getCell()) == 1 && utilBoard.distanceBetweenCells(units.get(1).getCell() , units.get(2).getCell()) == 1)
        || !(utilBoard.distanceBetweenCells(units.get(2).getCell() , units.get(0).getCell()) == 1 && utilBoard.distanceBetweenCells(units.get(2).getCell() , units.get(1).getCell()) == 1)){
            dissolveBattalion();
        }
    }

    private void dissolveBattalion() {
        //for (Integer i = 0; i < units.size(); i++){
       //     this.units.remove(i);
       // }
        units.clear();
    }

    public Boolean isEmpty(){
        return !(units.size() == 3);
    }
}

//al mover hay que hacer un for de 3 intentando mover cada unidad que no se haya movido
//en cuanto se logra mover una unidad, la removemos del batallon y se siguen tratando de mover los miembros restantes
