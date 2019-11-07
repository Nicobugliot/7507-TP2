package unit;

import cell.Cell;
import cellState.EmptyCell;
import cellState.OccupiedCell;
import exceptions.MovementException;
import java.util.*;

public class Catapult implements Unit{

    private Integer hp = 50;
    private Integer cost = 5;
    private Cell cell;
    private Integer meleeDamage = 0;
    private Integer rangedDamage = 20;
    private String type = "Artillery";

    @Override
    public void useAbility(Unit unit) {
        Set<Unit> affectedUnits = getAfectedUnitsByProjectile(unit);
        for (Unit affectedUnit: affectedUnits) {
            affectedUnit.applyDamage(rangedDamage); //ataca al objetivo
        }
    }

    //algortimo bfs para calcular los casilleros afectados por el impacto de la catapulta
    //devuelve un set de unidades afectadas
    private Set<Unit> getAfectedUnitsByProjectile(Unit targetUnit){
        //creo el set de retorno
        Set<Unit> affectedUnits = new HashSet<Unit>();
        // Marco todas las casillas como no visitadas
        //boolean visited[] = new boolean[400];
        Set<Unit> visitedUnits = new HashSet<Unit>();

        // Creo una cola para recorrer
        LinkedList<Unit> queue = new LinkedList<>();

        // Marco la celda actual como visitada
        //visited[targetUnit]=true;
        visitedUnits.add(targetUnit);
        queue.add(targetUnit);

        while (queue.size() != 0)
        {
            // Desencolo una celda y la agrego al set de retorno
            targetUnit = queue.poll();
            affectedUnits.add(targetUnit);

            //Tomo la celda objetivo
            Cell targetCell = targetUnit.getCell();

            // Tomo las celdas que rodean a la celda objetivo
            // Si alguna de estas no fué visitada la marco como visitadas y la encolo
            Iterator affectedCells = targetCell.getNearbyUnits().iterator(); //HACER MÉTODO getNearbyUnits() para las celdas, que devuelva un set con las unidades que rodean a esa celda
            while (affectedCells.hasNext())
            {
                Unit neighbourUnit = (Unit) affectedCells.next();
                if (!visitedUnits.contains(neighbourUnit))
                {
                    visitedUnits.add(neighbourUnit);
                    queue.add(neighbourUnit);
                }
            }
        }
        return affectedUnits;
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

    public String type() {
        return type;
    }


}
