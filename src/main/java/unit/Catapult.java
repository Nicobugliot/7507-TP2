package unit;

import cell.Cell;
import exceptions.AbilityException;
import exceptions.MovementException;
import utils.UtilBoard;

import java.util.*;

public class Catapult extends Unit {
    {
        hp = 50;
        cost = 5;
    }

    private Integer meleeDamage = 0;
    private Integer rangedDamage = 20;
    private static Integer MIN_DISTANCE_ATACK = 6;

    @Override
    public void useAbility(Unit unit) throws AbilityException {
        if (UtilBoard.distanceBetweenCells(this.cell, unit.getCell()) >= MIN_DISTANCE_ATACK) {
            Set<Unit> affectedUnits = getAfectedUnitsByProjectile(unit);
            for (Unit affectedUnit: affectedUnits) {
                affectedUnit.applyDamage(rangedDamage);
            }
        }else {
            throw new AbilityException("No puedo atacar a esa distancia");
        }
    }

    /*
    Algortimo BFS para calcular los casilleros afectados por el impacto de la catapulta
    devuelve un set de unidades afectadas
    */
    private Set<Unit> getAfectedUnitsByProjectile(Unit targetUnit){
        //creo el set de retorno
        Set<Unit> affectedUnits = new HashSet<Unit>();
        // Marco todas las casillas como no visitadas
        //boolean visited[] = new boolean[400];
        Set<Unit> visitedUnits = new HashSet<Unit>();

        // Creo una cola para recorrer
        LinkedList<Unit> queue = new LinkedList<>();

        // Marco la celda actual como visitada
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
            Iterator affectedCells = board.getNearbyUnits(targetCell).iterator();
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
    public Boolean canBeHealed(){
        return false;
    }

    @Override
    public void moveTo(Cell nextCell) {
        throw new MovementException("No me puedo mover, soy una catapulta");
    }
}
