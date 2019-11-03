package unity;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class InfantrySoldier implements Unity{

    private Integer hp = 100;
    private Cell cell;

    @Override
    public void ability(Unity unity) {
        unity.getDamage(10);
    }

    @Override
    public void moveTo(Cell nextCell) {
        Cell actualCell = this.getCell();

        if (this.unityCanMove(actualCell, nextCell)){
            // Libero la celda
            actualCell.changeState(new EmptyCell());
            actualCell.setUnity(null);

            // Lleno la nueva celda
            nextCell.changeState(new OccupiedCell());
            nextCell.setUnity(this);
            this.setCell(nextCell);
        }

    }

    @Override
    public void getDamage(Integer damage) {
        this.hp -= damage;
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
        cell.setUnity(this);
        cell.changeState(new OccupiedCell());
    }

    @Override
    public Cell getCell() {
        return cell;
    }

    private Boolean unityCanMove(Cell actualCell, Cell nextCell){

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
