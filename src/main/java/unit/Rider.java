package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;

public class Rider implements Unit{

    private Integer hp = 100;
    private Integer cost = 3;
    private Cell cell;
    private Integer meleeDamage = 5;
    private Integer rangedDamage = 15;
    private String type = "Cavalry";

    @Override
    public void ability(Unit unit) {
        if (cell.alliesNearby(self) || !cell.enemiesNearby(self)) {//si hay al menos un aliado cerca o ningun enemigo
            unit.applyDamage(rangedDamage);//ataca con el arco
        }else{
            unit.applyDamage(meleeDamage);//ataca con la espada
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

    public void type() {
        return self.type;
    }


}
