package test;

import Modelo.Cell;
import Modelo.exceptions.AbilityException;
import org.junit.jupiter.api.Test;
import Modelo.unit.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class HealerTests {


    @Test
    void Test01HealerHealsForExpectedAmount(){
        Unit healer = new Healer();
        Cell healerCell = new Cell(0,0);
        healer.setTeam(0);
        healer.setCell(healerCell);

        Unit subject = new TestDummy();
        Cell subjectCell = new Cell(1,0);
        subject.setTeam(0);
        subject.setCell(subjectCell);

        try {
            healer.useAbility(subject);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que la unidad fue curada por la cantidad esperada
        assertEquals(((TestDummy) subject).damageReceived(), -15);
    }

    @Test
    void Test02HealerHealsWithRangeTwoForExpectedAmount(){
        Unit healer = new Healer();
        Cell healerCell = new Cell(0,0);
        healer.setTeam(0);
        healer.setCell(healerCell);

        Unit subject = new TestDummy();
        Cell subjectCell = new Cell(2,0);
        subject.setTeam(0);
        subject.setCell(subjectCell);

        try {
            healer.useAbility(subject);
        } catch (AbilityException e) {
            e.printStackTrace();
        }
        //verifico que la unidad fue curada por la cantidad esperada
        assertEquals(((TestDummy) subject).damageReceived(), -15);
    }

    @Test
    void Test03HealerCantHealsForDistance(){
        Unit healer = new Healer();
        Cell healerCell = new Cell(0,0);
        healer.setTeam(0);
        healer.setCell(healerCell);

        Unit subject = new TestDummy();
        Cell subjectCell = new Cell(3,0);
        subject.setTeam(0);
        subject.setCell(subjectCell);

        assertThrows(AbilityException.class, () -> {
            healer.useAbility(subject);
        });
        assertEquals(((TestDummy) subject).damageReceived(), 0);
    }

    @Test
    void Test04HealerCantHealsEnemyUnit(){
        Unit healer = new Healer();
        Cell healerCell = new Cell(0,0);
        healer.setTeam(0);
        healer.setCell(healerCell);

        Unit subject = new TestDummy();
        Cell subjectCell = new Cell(0,0);
        subject.setTeam(1);
        subject.setCell(subjectCell);

        assertThrows(AbilityException.class, () -> {
            healer.useAbility(subject);
        });
        assertEquals(((TestDummy) subject).damageReceived(), 0);
    }

}