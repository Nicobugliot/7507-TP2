package test;

import algoChess.AlgoChess;
import cell.AlliedCell;
import cell.Cell;
import exceptions.GameOverException;
import exceptions.InsufficientPointsException;
import exceptions.MovementException;
import exceptions.OccupiedCellException;
import org.junit.jupiter.api.Test;
import player.Player;
import unit.InfantrySoldier;
import unit.Unit ;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserTest {

    @Test
    void Test00UserTryToSpendMorePointsThanItHave(){

        Player player = new Player("Jorge");

        for (int i = 0; i < 20; ++i){
            player.addUnit(new InfantrySoldier());
        }

        assertThrows(InsufficientPointsException.class, () -> {
            player.addUnit(new InfantrySoldier());
        });
    }


    @Test
    void Test01UserWithoutUnitiesLoseTheGame(){

        Unit soldierA = new InfantrySoldier();
        Unit soldierB = new InfantrySoldier();

        Player player = new Player("Jorge");
        player.addUnit(soldierA);
        player.addUnit(soldierB);

        player.looseUnit(soldierB);

        assertThrows(GameOverException.class, () -> {
            player.looseUnit(soldierA);
        });
    }
}