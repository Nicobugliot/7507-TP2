package Modelo;

import Modelo.exceptions.InsufficientPointsException;
import Modelo.unit.*;

import java.util.HashSet;
import java.util.Set;

import static Modelo.utils.UtilBoard.distanceBetweenCells;

public class Store {

    //private static Store board;

    private Store() {
    }

    public Boolean playerHasEnoughPoints(Integer unitCost, Integer playerPoints){
        return ( unitCost <= playerPoints );
    }

    public Unit buyInfantrySoldier(Player player) {
        Unit unit = new InfantrySoldier();
        if (playerHasEnoughPoints( unit.getCost() , player.getPoints())){
            player.addUnit(unit);
            return unit;
        }
        else {
            throw new InsufficientPointsException("El jugador no tiene los puntos necesarios para la compra");
        }
    }

    public Unit buyCatapult(Player player) {
        Unit unit = new Catapult();
        if (playerHasEnoughPoints( unit.getCost() , player.getPoints())){
            player.addUnit(unit);
            return unit;
        }
        else {
            throw new InsufficientPointsException("El jugador no tiene los puntos necesarios para la compra");
        }
    }

    public Unit buyHealer(Player player) {
        Unit unit = new Healer();
        if (playerHasEnoughPoints( unit.getCost() , player.getPoints())){
            player.addUnit(unit);
            return unit;
        }
        else {
            throw new InsufficientPointsException("El jugador no tiene los puntos necesarios para la compra");
        }
    }

    public Unit buyRider(Player player) {
        Unit unit = new Rider();
        if (playerHasEnoughPoints( unit.getCost() , player.getPoints())){
            player.addUnit(unit);
            return unit;
        }
        else {
            throw new InsufficientPointsException("El jugador no tiene los puntos necesarios para la compra");
        }
    }


}

