package test;

import cell.Cell;
import org.junit.jupiter.api.Test;
import unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnitSimpleCombatTest{


    @Test
    void Test00InfantrySoldierAttackHarmsUnitForExpectedDamage(){
        Unit attacker = new InfantrySoldier();
        Unit defender = new TestDummy();

        attacker.useAbility(defender);

        assertEquals(((TestDummy) defender).damageReceived(), 10);
    }

    @Test
    void Test01RiderUsesBowWhenAlone(){
        Unit attacker = new Rider();
        Unit defender = new TestDummy();
        Cell attackerCell = new StubCell();
        //seteo el comportamiento del stub para que haga de cuenta que no hay nadie alrededor de la unidad
        ((StubCell) attackerCell).pretendAlone();
        attacker.setCell(attackerCell);

        attacker.useAbility(defender);
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

        attacker.useAbility(defender);
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

        attacker.useAbility(defender);
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

        attacker.useAbility(defender);
        //verifico que el daño aplicado corresponda con el realizado por la espada
        assertEquals(((TestDummy) defender).damageReceived(), 5);
    }

    @Test
    void Test05HealerHealsForExpectedAmount(){
        Unit healer = new Healer();
        Unit subject = new TestDummy();

        healer.useAbility(subject);
        //verifico que la unidad fue curada por la cantidad esperada
        assertEquals(((TestDummy) subject).damageReceived(), -15);
    }

    @Test
    void Test06CatapultBlastDamagesTargetForExpectedAmount(){
        Unit catapult = new Catapult();
        Unit subject = new TestDummy();
        Cell targetCell = new StubCell();

        //configuro el stub para que diga que la única unidad cercana a la zona de impacto es la unidad objetivo
        ((StubCell) targetCell).addNearbyUnit(subject);
        subject.setCell(targetCell);

        catapult.useAbility(subject);
        //verifico que el daño aplicado corresponda con el realizado por la catapulta
        assertEquals(((TestDummy) subject).damageReceived(), 20);
    }

}