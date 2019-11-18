package unit;

import cell.Cell;
import exceptions.AbilityException;
import exceptions.BattalionException;

import java.util.List;
import java.util.Set;

public class Battalion extends Unit {

    private List<Unit> units;

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


}
