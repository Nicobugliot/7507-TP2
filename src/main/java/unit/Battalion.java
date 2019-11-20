package unit;

import cell.Cell;
import exceptions.AbilityException;
import exceptions.BattalionException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Battalion extends Unit {

    private List<Unit> units;

    public Battalion(){
        units = new ArrayList<>();
    }

    public void addUnit(Unit unit){
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
        //for (int i = 0; i < units.size(); i++){
            units.get(0).moveTo(nextCellA);
            units.get(1).moveTo(nextCellB);
            units.get(2).moveTo(nextCellC);
       // }                     //se tiene que hacer un ciclo y cuando una logra moverse, se la remueve del batallon
    }
}

//al mover hay que hacer un for de 3 intentando mover cada unidad que no se haya movido
//en cuanto se logra mover una unidad, la removemos del batallon y se siguen tratando de mover los miembros restantes
