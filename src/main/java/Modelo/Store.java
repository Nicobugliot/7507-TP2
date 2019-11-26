package Modelo;

import Modelo.unit.*;

import java.util.HashSet;
import java.util.Set;

import static Modelo.utils.UtilBoard.distanceBetweenCells;

public class Store {

    //private static Store board;

    private Store() {
    }

    public Unit buyInfantrySoldier(Player player) {
        Unit unit = new InfantrySoldier();
        player.addUnit(unit);
        return unit;
    }

    public Unit buyCatapult(Player player) {
        Unit unit = new Catapult();
        player.addUnit(unit);
        return unit;
    }

    public Unit buyHealer(Player player) {
        Unit unit = new Healer();
        player.addUnit(unit);
        return unit;
    }

    public Unit buyRider(Player player) {
        Unit unit = new Rider();
        player.addUnit(unit);
        return unit;
    }


}

