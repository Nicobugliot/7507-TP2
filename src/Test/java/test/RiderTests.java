package test;

import board.Board;
import cell.Cell;
import exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RiderTests {


    /*
    @Test
    void Test01RiderUsesBowWhenAlone(){
        //Creo un mock del tablero
        Board boardMock = mock(Board.class);

        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        attacker.setBoard(boardMock);//asigno el tablero mockeado a la unidad atacante que es la que le va a preguntar cosas al tablero
        attacker.setTeam(1); //Le asigno el equipo 1 al jinete
        attacker.setCell(attackerCell);//Le asigno una celda al atacante

        //seteo el comportamiento del mock para que haga de cuenta que no hay nadie cerca
        when(boardMock.alliesNearby(attackerCell,1)).thenReturn(false);
        when(boardMock.enemiesNearby(attackerCell,1)).thenReturn(false);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(((TestDummy) defender).damageReceived(), 15);
    }

    @Test
    void Test02RiderUsesBowWhenNextToAlliedInfantry(){
        //Creo un mock del tablero
        Board boardMock = mock(Board.class);

        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        attacker.setBoard(boardMock);//asigno el tablero mockeado a la unidad atacante que es la que le va a preguntar cosas al tablero
        attacker.setTeam(1); //Le asigno el equipo 1 al jinete
        attacker.setCell(attackerCell);//Le asigno una celda al atacante

        //seteo el comportamiento del mock para que haga de cuenta que hay aliados cerca y no enemigos
        when(boardMock.alliesNearby(attackerCell,1)).thenReturn(true);
        when(boardMock.enemiesNearby(attackerCell,1)).thenReturn(false);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(((TestDummy) defender).damageReceived(), 15);
    }

    @Test
    void Test03RiderUsesBowWhenNextToAlliedInfantryAndEnemies(){
        //Creo un mock del tablero
        Board boardMock = mock(Board.class);

        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        attacker.setBoard(boardMock);//asigno el tablero mockeado a la unidad atacante que es la que le va a preguntar cosas al tablero
        attacker.setTeam(1); //Le asigno el equipo 1 al jinete
        attacker.setCell(attackerCell);//Le asigno una celda al atacante

        //seteo el comportamiento del mock para que haga de cuenta que hay aliados cerca y enemigos
        when(boardMock.alliesNearby(attackerCell,1)).thenReturn(true);
        when(boardMock.enemiesNearby(attackerCell,1)).thenReturn(true);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(((TestDummy) defender).damageReceived(), 15);
    }

    @Test
    void Test04RiderUsesSwordWhenNoAlliesAndEnemiesArround(){
        //Creo un mock del tablero
        Board boardMock = mock(Board.class);

        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        attacker.setBoard(boardMock);//asigno el tablero mockeado a la unidad atacante que es la que le va a preguntar cosas al tablero
        attacker.setTeam(1); //Le asigno el equipo 1 al jinete
        attacker.setCell(attackerCell);//Le asigno una celda al atacante

        //seteo el comportamiento del mock para que haga de cuenta que hay enemigos cerca y no aliados
        when(boardMock.alliesNearby(attackerCell,1)).thenReturn(false);
        when(boardMock.enemiesNearby(attackerCell,1)).thenReturn(true);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por la espada
        assertEquals(((TestDummy) defender).damageReceived(), 5);
    }


     */

}