package test;

import cell.Cell;
import exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RiderTests {



    @Test
    void Test01RiderUsesBowWhenAlone(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que no hay nadie alrededor de la unidad
        ((StubCell) attackerCell).pretendAlone();
        attacker.setCell(attackerCell);

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
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay aliados cerca y no enemigos
        ((StubCell) attackerCell).pretendAlliesNearby();
        attacker.setCell(attackerCell);

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
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay aliados cerca y enemigos
        ((StubCell) attackerCell).pretendEnemiesAndAlliesNearby();
        attacker.setCell(attackerCell);

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
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay enemigos cerca y no aliados
        ((StubCell) attackerCell).pretendEnemiesNearby();
        attacker.setCell(attackerCell);

        try {
            attacker.useAbility(defender);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que el daño aplicado corresponda con el realizado por la espada
        assertEquals(((TestDummy) defender).damageReceived(), 5);
    }


}