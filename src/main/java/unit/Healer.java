package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class Rider implements Unit{

    private Integer hp = 75;
    private Integer cost = 2;
    private Cell cell;
    private Integer meleeDamage = 0;
    private Integer rangedDamage = 0;
    private Integer healingAmount = 15;
    private String type = "Healer";

    @Override
    public void ability(Unit unit) {
        if (unit.type != 'artillery' {//si no es una catapulta
            unit.applyDamage((-1)*healingAmount);
        }else{
            throw new AbilityException("Can't heal artilley units");
        }
    }

    @Override
    public void moveTo(Cell nextCell) {
        Cell actualCell = this.getCell();

        if (this.unitCanMove(actualCell, nextCell)){
            // Libero la celda
            actualCell.changeState(new EmptyCell());
            actualCell.setUnit(null);

            // Lleno la nueva celda
            nextCell.changeState(new OccupiedCell());
            nextCell.setUnit(this);
            this.setCell(nextCell);
        }

    }

    @Override
    public void applyDamage(Integer damage) {
        this.hp -= damage;
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
        cell.setUnit(this);
        cell.changeState(new OccupiedCell());
    }

    @Override
    public Cell getCell() {
        return cell;
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

    @Override
    public void getRemainingHP() {
        return this.hp;
    }

    public void type() {
        return self.type;
    }


}
