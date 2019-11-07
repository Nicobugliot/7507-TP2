package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class Healer extends Unit {
    {
        hp = 75;
        cost = 2;
        type = "Healer";
    }
    private Integer healingAmount = 15;

    @Override
    public void useAbility(Unit unit) {
        if (unit.type() != "artillery") {//si no es una catapulta
            unit.applyDamage((-1)*healingAmount);
        }else{
            //throw new AbilityException("Can't heal artilley units");
        }
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
        cell.setUnit(this);
        cell.changeState(new OccupiedCell());
    }


    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public Integer getCost() {
        return null;
    }

    @Override
    public Cell getCell() {
        return cell;
    }

    @Override
    public void die() {

    }

    @Override
    public String type() {
        return this.type;
    }

    private Boolean unitCanMove(Cell actualCell, Cell nextCell){

        if(!(getDistance(actualCell, nextCell) == 1)){
            throw new MovementException("No puedo moverme hasta ahi");
        }
        return true;
    }

    private Integer getDistance(Cell actualCell, Cell nextCell){
        Integer xPosition = Math.abs(actualCell.getXPosition() - nextCell.getXPosition());
        Integer yPosition = Math.abs(actualCell.getYPosition() - nextCell.getYPosition());

        return xPosition + yPosition;
    }

}
