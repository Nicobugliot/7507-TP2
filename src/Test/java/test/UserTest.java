package test;

import Modelo.exceptions.GameOverException;
import Modelo.exceptions.InsufficientPointsException;
import org.junit.jupiter.api.Test;
import Modelo.Player;
import Modelo.unit.InfantrySoldier;
import Modelo.unit.Unit ;

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
    void Test01UserWithEnoughPointsCanAffordANewUnit(){

        Player player = new Player("Jorge");

        for (int i = 0; i < 20; ++i){
            player.addUnit(new InfantrySoldier());
        }

        assertEquals(player.getUnitsAmount(), 20);
    }

    @Test
    void Test02UserWithoutUnitiesLoseTheGame(){

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