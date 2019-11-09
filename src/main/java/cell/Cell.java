package cell;

import cellState.State;
import player.Player;
import unit.Unit;

import java.util.Set;

public interface Cell {

    Boolean isEmpty();

    Integer getXPosition();

    Integer getYPosition();

    void changeState(State state);

    void setUnit(Unit unit);

    Unit getUnit();

    void deleteUnit();

    void setPlayer(Player player);

    void initializeUnit(Unit unit, Player player);

    boolean containsAllyOf(Integer team);
}
