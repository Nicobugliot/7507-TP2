package unit;

import cell.Cell;
import exceptions.AbilityException;
import exceptions.BattalionException;

import java.util.Set;

public class Battalion extends Unit {
    {
        hp = 100;
        cost = 1;
    }
    private Integer meleeDamage = 0;
    private Boolean dead = false;
    private Set<Unit> soldiers;

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        throw new AbilityException("Battalions can't attack");
    }

    public void addUnit(Unit soldier){
        soldiers.add(soldier);
    }

    public void removeUnit(Unit soldier) throws BattalionException {
        soldiers.remove(soldier);
        if (soldiers.size() < 3){
            for (Unit battalionSoldier : soldiers){
                this.removeUnit(battalionSoldier);
            }
            throw new BattalionException("This batallion has been disbanded");
        }
    }


    @Override
    public void moveTo(Cell nextCell) {
        for (Unit soldier : soldiers){
            moveTo(nextCell);//falta la lógica para mandar a cada soldado a su celda correspondiente
        }
    }


}
