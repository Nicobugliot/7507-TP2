package test;

import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UnitSimpleCombatTest{

    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.useAbility(defender);

        assertEquals(defender.damageReceived(), 10);
    }

    @Test
    void Test01RiderUsesBowWhenAlone(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que no hay nadie alrededor de la unidad
        attackerCell.pretendAlone();
        attacker.setCell(attackerCell);

        attacker.useAbility(defender);
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(defender.damageReceived(), 15);
    }

    @Test
    void Test02RiderUsesBowWhenNextToAlliedInfantry(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay aliados cerca y no enemigos
        attackerCell.pretendAlliesNearby();
        attacker.setCell(attackerCell);

        attacker.useAbility(defender);
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(defender.damageReceived(), 15);
    }

    @Test
    void Test03RiderUsesBowWhenNextToAlliedInfantryAndEnemies(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay aliados cerca y enemigos
        attackerCell.pretendEnemies&AlliesNearby();
        attacker.setCell(attackerCell);

        attacker.useAbility(defender);
        //verifico que el daño aplicado corresponda con el realizado por el arco
        assertEquals(defender.damageReceived(), 15);
    }

    @Test
    void Test04RiderUsesSwordWhenNoAlliesAndEnemiesArround(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que hay enemigos cerca y no aliados
        attackerCell.pretendEnemiesNearby();
        attacker.setCell(attackerCell);

        attacker.useAbility(defender);
        //verifico que el daño aplicado corresponda con el realizado por la espada
        assertEquals(defender.damageReceived(), 5);
    }

    @Test
    void Test05HealerHealsForExpectedAmount(){
        Unit healer = new Healer();
        Unit subject = new TestDummy();

        healer.useAbility(subject);
        //verifico que el daño aplicado corresponda con el realizado por la espada
        assertEquals(defender.damageReceived(), -15);
    }







}